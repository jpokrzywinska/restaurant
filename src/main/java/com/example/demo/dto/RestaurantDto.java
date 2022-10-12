package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RestaurantDto {
    private Long Id;
    private String name;
    private Location location;
    private String typeOfFood;

    public RestaurantDto(String name, Location location, String typeOfFood) {
        this.name = name;
        this.location = location;
        this.typeOfFood = typeOfFood;
    }
}
