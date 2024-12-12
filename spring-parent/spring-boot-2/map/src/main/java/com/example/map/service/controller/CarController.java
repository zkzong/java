package com.example.map.service.controller;

import com.example.map.service.CarService;
import com.example.map.service.ServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/enum")
    public String getByEnum(@RequestParam String brand) {
        ServiceEnum serviceEnum = ServiceEnum.getServiceEnum(brand);
        String service = serviceEnum.getService();
        CarService carService = map.get(service);
        System.out.println(carService.price());
        return "success";
    }
}
