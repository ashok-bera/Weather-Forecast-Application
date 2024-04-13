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
public class WeatherForecastItemsWeatherDTO {

    @JsonProperty("state")
    public Integer state;

    @JsonProperty("text")
    public String text;

    @JsonProperty("icon")
    public String icon;
}
