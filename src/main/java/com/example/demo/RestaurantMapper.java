package com.example.demo;

import com.example.demo.dto.Location;
import com.example.demo.dto.RestaurantDto;
import com.example.demo.model.RestaurantEntity;

public class RestaurantMapper {
    public static RestaurantEntity toEntity(RestaurantDto restaurantDto) {
        return new RestaurantEntity(restaurantDto.getId(), restaurantDto.getName(), restaurantDto.getLocation().getX(), restaurantDto.getLocation().getY(), restaurantDto.getTypeOfFood());
    }

    public static RestaurantDto toDto(RestaurantEntity entity) {
        return new RestaurantDto(entity.getId(), entity.getName(), new Location(entity.getLocationX(), entity.getLocationY()), entity.getTypeOfFood());
    }
}
