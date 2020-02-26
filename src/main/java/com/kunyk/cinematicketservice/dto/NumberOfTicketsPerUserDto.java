package com.kunyk.cinematicketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberOfTicketsPerUserDto {
    private Long userId;
    private Integer numberOfTickets;
}
