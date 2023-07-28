package com.service.UserService.service.impl;

import com.service.UserService.entity.Hotel;
import com.service.UserService.entity.Ratings;
import com.service.UserService.entity.User;
import com.service.UserService.exception.ResourceNotFoundException;
import com.service.UserService.external.service.HotelService;
import com.service.UserService.repository.UserRepository;
import com.service.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> userDetails = userRepository.findAll();

        return userDetails.stream().peek((user) -> {
                 List<Ratings> ratingsList = getRatingDetails(user.getUserId());
                 user.setRatings(ratingsList);
        }).collect(Collectors.toList());
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserId not found: " + userId));

//        "ratings/user-rating" ?userId=b3cd9f0a-1477-46e3-8989-41219f0774e2

        List<Ratings> ratingsList = getRatingDetails(userId);
        user.setRatings(ratingsList);
        return user;
    }

    @Override
    public String deleteUser(String userId) {
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
        } else {
            throw new ResourceNotFoundException("UserId not found: " +userId);
        }

        return "Deletion Success Full";
    }

    @Override
    public User updateUser(User user) {
        return  null;
    }

    private List<Ratings> getRatingDetails(String userId) {

        Ratings[]  userRating = restTemplate.getForObject("http://RATINGS-SERVICE/ratings/user-rating?userId="+userId, Ratings[].class);
        log.info(Arrays.toString(userRating));

        List<Ratings> ratings = null;
        if (userRating != null) {
            ratings = Arrays.stream(userRating).toList();
        }

        assert ratings != null;
        return ratings.stream().peek((rating) -> {
            Hotel hotelDetails = hotelService.getHotelDetails(rating.getHotelId());
//            ResponseEntity<Hotel> hotelDetails = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/hotel?hotelId=" + rating.getHotelId(), Hotel.class);
//            rating.setHotel(hotelDetails.getBody());
            rating.setHotel(hotelDetails);
        }).collect(Collectors.toList());
    }
}
