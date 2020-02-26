package com.kunyk.cinematicketservice.controller;

import com.kunyk.cinematicketservice.dto.NumberOfTicketsPerUserDto;
import com.kunyk.cinematicketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/getTopVisitors")
    public ResponseEntity<?> getTopVisitorsWithLimit(@RequestParam(value = "limit", defaultValue = "10") Integer limitUsersQuantity) {
        List<NumberOfTicketsPerUserDto> count = ticketService.getNumberOfTicketsPerUser(limitUsersQuantity);
        return ResponseEntity.status(200).body(count);
    }
}
