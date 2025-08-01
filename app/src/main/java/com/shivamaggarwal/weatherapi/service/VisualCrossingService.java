package com.shivamaggarwal.weatherapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.shivamaggarwal.weatherapi.model.external.VisualCrossingResponse;

@Service
public class VisualCrossingService {

    private String apiKey;

    private final RestClient restClient;

    public VisualCrossingService(RestClient.Builder restClientBuilder, @Value("${VISUAL_CROSSING_API_KEY}") String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key must not be null or empty");
        }
        this.apiKey = apiKey;
        this.restClient = restClientBuilder.baseUrl("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services").build();
    }

    public VisualCrossingResponse getWeatherDate(String city) {
        return this.restClient.get().uri("/timeline/{city}?unitGroup=us&key={apiKey}&contentType=json", city, this.apiKey).retrieve().body(VisualCrossingResponse.class);
    }
}
