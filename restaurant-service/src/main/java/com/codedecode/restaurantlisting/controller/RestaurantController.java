package com.codedecode.restaurantlisting.controller;

import com.codedecode.restaurantlisting.dto.RestaurantDTO;
import com.codedecode.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
       List<RestaurantDTO> restaurantDTOS = restaurantService.findAllRestaurants();
         return ResponseEntity.ok(restaurantDTOS);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        // Call the service to add the restaurant
        RestaurantDTO addedRestaurant = restaurantService.addRestaurant(restaurantDTO);
        return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id) {
        RestaurantDTO restaurantDTO = restaurantService.findRestaurantById(id);
        if (restaurantDTO != null) {
            return ResponseEntity.ok(restaurantDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
