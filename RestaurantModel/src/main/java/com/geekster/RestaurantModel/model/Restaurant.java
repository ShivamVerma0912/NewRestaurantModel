package com.geekster.RestaurantModel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    private String restaurantId;

    private String restaurantName;

    private String address;

    private String phoneNumber;

    private String speciality;

    private String totalStaffs;
}
