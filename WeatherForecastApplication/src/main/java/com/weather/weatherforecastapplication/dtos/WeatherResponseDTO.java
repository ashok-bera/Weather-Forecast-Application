package com.weather.weatherforecastapplication.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {

    @JsonProperty("message")
    public String message;

    @JsonProperty("forecast")
    public WeatherForecastDTO weatherForecastDTO;

    @JsonProperty("location")
    public WeatherLocationDTO weatherLocationDTO;

    @JsonProperty("error")
    public WeatherErrorDTO weatherErrorDTO;
}
