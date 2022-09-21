package org.example.sb.redis.controller;

import org.example.sb.redis.domain.City;
import org.example.sb.redis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zong on 2017/6/5.
 */
@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/name", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/api/city/id", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "id", required = true) Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void updateCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void deleteCity(@RequestParam Long id) {
        cityService.deleteCity(id);
    }
}
