package com.geekster.RestaurantModel.repository;

import com.geekster.RestaurantModel.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Repo {

    private List<Restaurant> restaurantList;

    public Repo(List<Restaurant> restaurantList) {this.restaurantList = new ArrayList<>();}

    public List<Restaurant> getRestaurantList() {
        return this.restaurantList;
    }

    public boolean add(Restaurant restaurant) {
        restaurantList.add(restaurant);
        return true;
    }
    public boolean remove(Restaurant restaurant){
        restaurantList.remove(restaurant);
        return true;
    }
}
