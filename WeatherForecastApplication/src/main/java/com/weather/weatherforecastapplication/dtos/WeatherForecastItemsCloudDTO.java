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
public class WeatherForecastItemsCloudDTO {

    @JsonProperty("high")
    public Integer high;

    @JsonProperty("low")
    public Integer low;

    @JsonProperty("middle")
    public Integer middle;
}
