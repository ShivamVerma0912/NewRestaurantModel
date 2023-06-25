package com.geekster.RestaurantModel.controller;

import com.geekster.RestaurantModel.model.Restaurant;
import com.geekster.RestaurantModel.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public String postRestaurant(@RequestBody Restaurant restaurant){

        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public Restaurant getRestaurantByID(@PathVariable String restaurantId){
        return restaurantService.restaurantGetById(restaurantId);
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @PutMapping(value = "/restaurant/{restaurantId}/{restaurantName}")
    public String updateRestaurant(@PathVariable String restaurantId,@PathVariable String restaurantName){
        return restaurantService.updateRestaurantById(restaurantId,restaurantName)? "Updated successfully":"Not found restaurant with this id..!!";
    }
    @DeleteMapping(value = "/restaurant/{restaurantId}")
    public String deleteUserByUserId(@PathVariable String restaurantId){
        return restaurantService.removeRestaurantByRestaurantId(restaurantId);
    }
}
