package com.service.UserService.external.service;

import com.service.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("hotels/hotel")
    Hotel getHotelDetails(@RequestParam String hotelId);

}
