package com.service.HotelService.controller;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.service.HotelService;
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

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Hotel>> getAllHotel() {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @GetMapping("/hotel")
    ResponseEntity<Hotel> getHotelDetails(@RequestParam String hotelId) {
        return new ResponseEntity<>(hotelService.getHotel(hotelId), HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<Object> deleteHotel(@RequestParam String hotelId){
        return new ResponseEntity<>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
    }
}
