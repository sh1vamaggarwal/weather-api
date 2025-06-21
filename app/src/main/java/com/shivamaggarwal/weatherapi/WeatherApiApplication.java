package com.shivamaggarwal.weatherapi;

public class WeatherApiApplication {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new WeatherApiApplication().getGreeting());
    }
}
