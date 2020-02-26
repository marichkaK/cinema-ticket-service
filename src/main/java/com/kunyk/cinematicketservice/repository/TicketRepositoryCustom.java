package com.kunyk.cinematicketservice.repository;

import com.kunyk.cinematicketservice.projection.NumberOfTicketsPerUserProjection;

import java.util.List;

public interface TicketRepositoryCustom {

    List<NumberOfTicketsPerUserProjection> getNumberOfTicketsPerUser(Integer limit);
}
