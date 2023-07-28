package com.service.RatingsService.service;

import com.service.RatingsService.entity.Ratings;

import java.util.List;

public interface RatingsService {

    Ratings createRatings(Ratings ratings);
    List<Ratings> getAllRatings();
    List<Ratings> getAllRatingsByUserId(String userId);
    List<Ratings> getAllRatingsByHotelId(String hotelId);
    String deleteRatings(String ratingId);

}
