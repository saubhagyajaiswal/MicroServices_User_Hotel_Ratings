package com.service.RatingsService.repository;

import com.service.RatingsService.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingsRepository extends JpaRepository<Ratings, String> {

    List<Ratings> findByUserId(String userId);
    List<Ratings> findByHotelId(String hotelId);
}
