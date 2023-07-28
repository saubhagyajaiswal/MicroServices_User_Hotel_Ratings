package com.service.RatingsService.service.impl;

import com.service.RatingsService.entity.Ratings;
import com.service.RatingsService.repository.RatingsRepository;
import com.service.RatingsService.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RatingServiceImpl implements RatingsService {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    public Ratings createRatings(Ratings ratings) {
        return ratingsRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingsRepository.findAll();
    }

    @Override
    public List<Ratings> getAllRatingsByUserId(String userId) {
        return ratingsRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getAllRatingsByHotelId(String hotelId) {
        return ratingsRepository.findByHotelId(hotelId);
    }

    @Override
    public String deleteRatings(String ratingId) {
        if(ratingsRepository.findById(ratingId).isPresent()){
            ratingsRepository.deleteById(ratingId);
        } else {
            return ("UserId not found: " +ratingId);
        }

        return "Deletion Success Full";
    }
}
