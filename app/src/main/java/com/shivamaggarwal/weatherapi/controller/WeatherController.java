package com.shivamaggarwal.weatherapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Value("classpath:data/sample.json")
    private Resource resource;
    
    private final VisualCrossingService visualCrossingService;

    private final WeatherMapper weatherMapper;

    public WeatherController(VisualCrossingService visualCrossingService, WeatherMapper weatherMapper) {
        this.visualCrossingService = visualCrossingService;
        this.weatherMapper = weatherMapper;
    }
    
    @GetMapping("/weather")
    public WeatherDto getWeather(@RequestParam("city") String city) {
        logger.info("Received GET /weather request for city: '{}'", city);
        try {
            var visualCrossingResponse = visualCrossingService.getWeatherDate(city);
            logger.debug("Visual Crossing API response for city '{}': {}", city, visualCrossingResponse);
            var weatherDto = weatherMapper.toWeatherDto(visualCrossingResponse);
            logger.info("Successfully processed GET /weather request for city: '{}'", city);
            return weatherDto;
        } catch (Exception e) {
            logger.error("Failed to process GET /weather request for city: '{}'", city, e);
            throw e;
        }
    }
}
