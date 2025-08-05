package com.shivamaggarwal.weatherapi.service;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestClient;

import com.shivamaggarwal.weatherapi.exception.VisualCrossingException;
import com.shivamaggarwal.weatherapi.model.external.VisualCrossingResponse;

@Service
public class VisualCrossingService {

    private static final Logger logger = LoggerFactory.getLogger(VisualCrossingService.class);

    private String apiKey;

    private final RestClient restClient;

    public VisualCrossingService(RestClient.Builder restClientBuilder, @Value("${VISUAL_CROSSING_API_KEY}") String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key must not be null or empty");
        }
        this.apiKey = apiKey;
        this.restClient = restClientBuilder.baseUrl("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services").build();
    }

    @Cacheable(value = "weatherCache", key = "#city")
    public VisualCrossingResponse getWeatherDate(String city) {
        logger.info("Cache miss for city: {}. Fetching weather data from Visual Crossing API.", city);
        try {
            VisualCrossingResponse response = restClient.get()
                .uri("/timeline/{city}?unitGroup=us&key={apiKey}&contentType=json", city, this.apiKey)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, clientResponse) -> {
                    String body = StreamUtils.copyToString(clientResponse.getBody(), StandardCharsets.UTF_8);
                    logger.error("Error from Visual Crossing API for city: {}. Status: {}, Body: {}", city, clientResponse.getStatusCode().value(), body);
                    throw new VisualCrossingException("Weather API error", clientResponse.getStatusCode().value(), body);
                })
                .body(VisualCrossingResponse.class);
            logger.debug("Successfully fetched weather data for city: {}", city);
            return response;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while fetching weather for city: {}", city, e);
            throw e;
        }
    }
}
