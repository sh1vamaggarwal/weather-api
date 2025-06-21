package com.shivamaggarwal.weatherapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {
    @Test void appHasAGreeting() {
        WeatherApiApplication classUnderTest = new WeatherApiApplication();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
