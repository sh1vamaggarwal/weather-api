package com.shivamaggarwal.weatherapi.mapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.shivamaggarwal.weatherapi.dto.WeatherDto;
import com.shivamaggarwal.weatherapi.dto.WeatherDto.Main;
import com.shivamaggarwal.weatherapi.model.external.VisualCrossingResponse;

@Component
public class WeatherMapper {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherMapper.class);

    public WeatherDto toWeatherDto(VisualCrossingResponse externalResponse) {
        if (externalResponse == null) {
            LOGGER.error("External API Response is Null");
            return null;
        }

        WeatherDto dto = new WeatherDto();
        dto.setName(externalResponse.getAddress());
        
        Main main = new Main();
        main.setTemp(externalResponse.getCurrentConditions().getTemp());
        main.setFeels_like(externalResponse.getCurrentConditions().getFeelslike());
        main.setTemp_min(externalResponse.getDays().get(0).getTempmin());
        main.setTemp_max(externalResponse.getDays().get(0).getTempmax());
        main.setPressure(externalResponse.getDays().get(0).getPressure());
        main.setHumidity(externalResponse.getDays().get(0).getHumidity());
        dto.setMain(main);

        WeatherDto.Weather weather = new WeatherDto.Weather();
        weather.setMain(externalResponse.getCurrentConditions().getConditions());
        weather.setDescription(externalResponse.getDays().get(0).getDescription());
        weather.setIcon(externalResponse.getCurrentConditions().getIcon());
        dto.setWeather(List.of(weather));

        WeatherDto.Wind wind = new WeatherDto.Wind();
        wind.setSpeed(externalResponse.getCurrentConditions().getWindspeed());
        wind.setDeg(externalResponse.getCurrentConditions().getWinddir());
        dto.setWind(wind);
        
        return dto;
    }
}
