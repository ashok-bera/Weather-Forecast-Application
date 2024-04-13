package com.weather.weatherforecastapplication.services;

import com.weather.weatherforecastapplication.dtos.WeatherResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ForecastService {
    ResponseEntity<WeatherResponseDTO> getForecastSummaryByLocationName(String locationName);

    ResponseEntity<WeatherResponseDTO> getHourlyForecastByLocationName(String locationName);
}
