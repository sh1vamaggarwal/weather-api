package com.shivamaggarwal.weatherapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivamaggarwal.weatherapi.model.WeatherResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class WeatherController {

    @Value("classpath:data/sample.json")
    private Resource resource;
    
    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = objectMapper.readValue(resource.getInputStream(), WeatherResponse.class);
        return weatherResponse;
    }

}
