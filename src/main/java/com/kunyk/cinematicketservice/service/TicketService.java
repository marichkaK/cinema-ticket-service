package com.kunyk.cinematicketservice.service;

import com.kunyk.cinematicketservice.dto.NumberOfTicketsPerUserDto;
import com.kunyk.cinematicketservice.projection.NumberOfTicketsPerUserProjection;
import com.kunyk.cinematicketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<NumberOfTicketsPerUserDto> getNumberOfTicketsPerUser(Integer limitUsersQuantity) {
        return ticketRepository.getNumberOfTicketsPerUser(limitUsersQuantity)
                .stream()
                .map(NumberOfTicketsPerUserProjection::toDto)
                .collect(Collectors.toList());
    }
}
