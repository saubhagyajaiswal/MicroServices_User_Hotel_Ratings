package com.service.RatingsService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ratingId;

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
