package com.service.HotelService.service.impl;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.exception.ResourceNotFoundException;
import com.service.HotelService.repository.HotelRepository;
import com.service.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        System.out.println("get all hotels");
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found : "+ hotelId));
    }

    @Override
    public String deleteHotel(String hotelId) {
        if(hotelRepository.findById(hotelId).isPresent()){
            hotelRepository.deleteById(hotelId);
        } else {
            throw new ResourceNotFoundException("Hotel not found: " +hotelId);
        }

        return "Deletion Success Full";
    }
}
