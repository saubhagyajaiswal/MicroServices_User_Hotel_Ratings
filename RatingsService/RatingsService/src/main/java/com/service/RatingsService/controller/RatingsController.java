package com.service.RatingsService.controller;

import com.service.RatingsService.entity.Ratings;
import com.service.RatingsService.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingsService ratingsService;

    @PostMapping
    ResponseEntity<Ratings> createRating(@RequestBody Ratings ratings){
        return new ResponseEntity<>(ratingsService.createRatings(ratings), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Ratings>> getAllRatings() {
        return new ResponseEntity<>(ratingsService.getAllRatings(), HttpStatus.OK);
    }

    @GetMapping("/user-rating")
    ResponseEntity<List<Ratings>> getAllRatingsByUserId(@RequestParam String userId) {
        return new ResponseEntity<>(ratingsService.getAllRatingsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/hotel-rating")
    ResponseEntity<List<Ratings>> getAllRatingsByHotelId(@RequestParam String hotelId) {
        return new ResponseEntity<>(ratingsService.getAllRatingsByHotelId(hotelId), HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<Object> deleteRating(@RequestParam String ratingId) {
        return new ResponseEntity<>(ratingsService.deleteRatings(ratingId), HttpStatus.OK);
    }
}
