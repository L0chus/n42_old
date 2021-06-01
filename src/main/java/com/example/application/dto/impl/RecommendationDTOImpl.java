package com.example.application.dto.impl;

import com.example.application.dto.RecommendationDTO;

public class RecommendationDTOImpl implements RecommendationDTO {

    private String id;

    private String name;

    private String description;

    //getter

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    // setter


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
