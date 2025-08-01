package com.shivamaggarwal.weatherapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivamaggarwal.weatherapi.dto.WeatherDto;
import com.shivamaggarwal.weatherapi.mapper.WeatherMapper;
import com.shivamaggarwal.weatherapi.service.VisualCrossingService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class WeatherController {

    @Value("classpath:data/sample.json")
    private Resource resource;
    
    private final VisualCrossingService visualCrossingService;

    private final WeatherMapper weatherMapper;

    public WeatherController(VisualCrossingService visualCrossingService, WeatherMapper weatherMapper) {
        this.visualCrossingService = visualCrossingService;
        this.weatherMapper = weatherMapper;
    }
    
    @GetMapping("/weather")
    public WeatherDto getWeather(@RequestParam("city") String city) throws Exception {
        var VisualCrossingResponse = visualCrossingService.getWeatherDate(city);
        return weatherMapper.toWeatherDto(VisualCrossingResponse);
    }

}
