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
public class WeatherForecastItemsWindDTO {
    @JsonProperty("unit")
    public String unit;
    @JsonProperty("direction")
    public String direction;
    @JsonProperty("avg")
    public Integer avg;
    @JsonProperty("min")
    public Integer min;
    @JsonProperty("max")
    public Integer max;
    @JsonProperty("text")
    public String text;
    @JsonProperty("significationWind")
    public Boolean significationWind;
    @JsonProperty("gusts")
    public WeatherForecastItemsWindGustsDTO weatherForecastItemsWindGustsDTO;
}
