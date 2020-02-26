package com.kunyk.cinematicketservice.repository;


import com.kunyk.cinematicketservice.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>, TicketRepositoryCustom {

}
