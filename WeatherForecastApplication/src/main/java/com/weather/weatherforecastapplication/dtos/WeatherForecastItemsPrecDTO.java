package com.weather.weatherforecastapplication.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastItemsPrecDTO {

    @JsonProperty("sum")
    public Integer sum;

    @JsonProperty("sumAsRain")
    public Integer sumAsRain;

    @JsonProperty("probability")
    public Integer probability;

    @JsonProperty("class")
    public Integer precClass ;
}