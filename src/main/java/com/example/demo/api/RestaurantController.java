package com.example.demo.api;

import com.example.demo.dto.RestaurantDto;
import com.example.demo.service.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant")
    public RestaurantDto registerRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.save(restaurantDto);
    }
}
