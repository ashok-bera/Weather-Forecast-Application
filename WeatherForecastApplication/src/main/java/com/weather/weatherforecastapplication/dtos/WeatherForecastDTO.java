package com.weather.weatherforecastapplication.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDTO {

    @JsonProperty("source")
    public String source;

    @JsonProperty("point")
    public String point;

    @JsonProperty("nextUpdate")
    public String nextUpdate;

    @JsonProperty("forecastDate")
    public String forecastDate;

    @JsonProperty("items")
    public List<WeatherForecastItemsDTO> items;
}
