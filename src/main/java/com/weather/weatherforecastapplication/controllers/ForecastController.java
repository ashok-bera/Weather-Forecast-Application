package com.weather.weatherforecastapplication.controllers;

import com.weather.weatherforecastapplication.dtos.WeatherResponseDTO;
import com.weather.weatherforecastapplication.services.ForecastService;
import com.weather.weatherforecastapplication.services.impl.ForecastServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastServiceImpl forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/summary/{locationName}")
    public ResponseEntity<WeatherResponseDTO> getForecastSummaryByLocationName(@PathVariable String locationName) {
        return forecastService.getForecastSummaryByLocationName(locationName);
    }

    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<?> getHourlyForecastByLocationName(@PathVariable String locationName) {
        return forecastService.getHourlyForecastByLocationName(locationName);
    }
}
