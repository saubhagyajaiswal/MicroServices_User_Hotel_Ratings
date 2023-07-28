package com.service.HotelService.service;

import com.service.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotel(String hotelId);
    String deleteHotel(String hotelId);
}
