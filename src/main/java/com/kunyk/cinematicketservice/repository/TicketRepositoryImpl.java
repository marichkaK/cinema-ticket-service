package com.kunyk.cinematicketservice.repository;

import com.kunyk.cinematicketservice.projection.NumberOfTicketsPerUserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketRepositoryImpl implements TicketRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public TicketRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<NumberOfTicketsPerUserProjection> getNumberOfTicketsPerUser(Integer limit) {
        GroupOperation groupTickets = Aggregation.group("user").first("user").as("user").count().as("numberOfTickets");
        SortOperation sortByNumDesc = Aggregation.sort(Sort.by(Sort.Direction.DESC, "numberOfTickets"));
        LimitOperation limitOperation = Aggregation.limit(limit);
        MatchOperation matchOperation = Aggregation.match(new Criteria("user").ne(null));

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, groupTickets, limitOperation, sortByNumDesc);
        AggregationResults<NumberOfTicketsPerUserProjection> result = mongoTemplate.aggregate(
                aggregation, "ticket", NumberOfTicketsPerUserProjection.class);
        return result.getMappedResults();
    }
}
