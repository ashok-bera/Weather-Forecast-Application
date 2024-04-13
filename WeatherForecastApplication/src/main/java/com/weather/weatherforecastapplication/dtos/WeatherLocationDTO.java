package com.weather.weatherforecastapplication.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherLocationDTO {

    @JsonProperty("code")
    public String code;

    @JsonProperty("timezone")
    public String timezone;

    @JsonProperty("name")
    public String name;

    @JsonProperty("coordinates")
    public WeatherLocationCoordinatesDTO weatherLocationCoordinatesDTO;
}
