package com.example.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private Map<String, CarService> map;

    @RequestMapping("/price")
    public String price() {
        CarService audiService = map.get("audiService");
        System.out.println(audiService.price());
        CarService bmwService = map.get("bmwService");
        System.out.println(bmwService.price());
        return "success";
    }
}
