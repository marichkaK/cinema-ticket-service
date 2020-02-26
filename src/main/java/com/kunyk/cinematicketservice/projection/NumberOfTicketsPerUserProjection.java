package com.kunyk.cinematicketservice.projection;

import com.kunyk.cinematicketservice.dto.NumberOfTicketsPerUserDto;
import com.kunyk.cinematicketservice.model.User;
import lombok.Data;

@Data
public class NumberOfTicketsPerUserProjection {

    private User user;
    private Integer numberOfTickets;

    public  NumberOfTicketsPerUserDto toDto() {
        return NumberOfTicketsPerUserDto.builder()
                .userId(user.getUserId())
                .numberOfTickets(numberOfTickets)
                .build();
    }
}
