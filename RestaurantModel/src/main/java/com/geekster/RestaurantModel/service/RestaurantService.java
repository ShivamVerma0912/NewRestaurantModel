package com.geekster.RestaurantModel.service;

import com.geekster.RestaurantModel.model.Restaurant;
import com.geekster.RestaurantModel.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    Repo repo;

    public List<Restaurant> getAllRestaurant(){
        return repo.getRestaurantList();
    }

    public String addRestaurant(Restaurant restaurant) {
        boolean addedStatus = repo.add(restaurant);
        if(addedStatus) return "Restaurant added successfully";
        return "Restaurant addition failed..!!";
    }

    public Restaurant restaurantGetById(String restaurantId) {
        List<Restaurant> restaurantList = repo.getRestaurantList();
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getRestaurantId().equals(restaurantId))
                return restaurant;
        }
        return null;
    }

    public boolean updateRestaurantById(String restaurantId,String restaurantName) {
        List<Restaurant> restaurantList = repo.getRestaurantList();
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getRestaurantId().equals(restaurantId)){
                //remove original
                repo.remove(restaurant);

                restaurant.setRestaurantName(restaurantName);

                repo.add(restaurant);
                return true;
            }
        }
        return false;
    }

    public String removeRestaurantByRestaurantId(String restaurantId) {
        String status = "";
        boolean dResponse = false;
        if(restaurantId != null){
            List<Restaurant> restaurantList = repo.getRestaurantList();
            for(Restaurant restaurant : restaurantList){
                if(restaurant.getRestaurantId().equals(restaurantId)) {
                    dResponse = repo.remove(restaurant);
                    if (dResponse)
                        status = "RestaurantId " + restaurantId + " deleted successfully";
                    else
                        status = "RestaurantId " + restaurantId + " was not found";
                    return status;
                }
            }
        }
        return "RestaurantId "+restaurantId +" was not found..!!!";
    }

}
