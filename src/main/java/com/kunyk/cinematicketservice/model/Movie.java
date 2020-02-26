package com.kunyk.cinematicketservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Movie {

    private String name;

    private Integer duration;

    private Integer minAge;

    private String country;

    private List<String> genres;
}
