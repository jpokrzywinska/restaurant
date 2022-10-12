package com.example.demo.service;

import com.example.demo.dto.RestaurantDto;
import com.example.demo.exceptions.RestaurantAlreadyExistsException;
import com.example.demo.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.example.demo.RestaurantMapper.toDto;
import static com.example.demo.RestaurantMapper.toEntity;

@Service
public class RestaurantService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantDto save(RestaurantDto restaurantDto) {
        if (Objects.nonNull(restaurantDto.getId()) && repository.findById(restaurantDto.getId()).isPresent()) {
            throw new RestaurantAlreadyExistsException(restaurantDto.getId());
        }
        var entity = repository.save(toEntity(restaurantDto));
        LOGGER.info("New restaurant registered: id={}, name={}, locationX={}, locationY={}, type={}", entity.getId(), entity.getName(), entity.getLocationX(), entity.getLocationY(), entity.getTypeOfFood());
        return toDto(entity);
    }
}
