package com.galvanize.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
final class RestaurantController {

    private List<Restaurant> restaurants = new ArrayList<>();

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantController(){

    }

    public RestaurantController(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/api/restaurants")
    public List<Restaurant> getRestaurants(){
        //return restaurants;
        return restaurantRepository.list();
    }

    @PostMapping("/api/restaurants")
    public Restaurant addRestaurants(@RequestBody Restaurant newRestaurant){

        //restaurants.add(newRestaurant);
        return restaurantRepository.save(newRestaurant);

    }
}
