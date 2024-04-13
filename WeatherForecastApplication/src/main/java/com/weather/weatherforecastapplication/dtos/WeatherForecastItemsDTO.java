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
public class WeatherForecastItemsDTO {

    @JsonProperty("date")
    public String date;

    @JsonProperty("period")
    public Integer period;

    @JsonProperty("pressure")
    public Float pressure;

    @JsonProperty("relativeHumidity")
    public Integer relativeHumidity;

    @JsonProperty("dateWithTimezone")
    public String dateWithTimezone;

    @JsonProperty("freshSnow")
    public Float freshSnow;

    @JsonProperty("snowHeight")
    public Float snowHeight;

    @JsonProperty("weather")
    public WeatherForecastItemsWeatherDTO weatherForecastItemsWeatherDTO;

    @JsonProperty("prec")
    public WeatherForecastItemsPrecDTO weatherForecastItemsPrecDTO;

    @JsonProperty("sunHours")
    public Float sunHours;

    @JsonProperty("rainHours")
    public Float rainHours;

    @JsonProperty("isNight")
    public Boolean isNight;

    @JsonProperty("temperature")
    public WeatherForecastItemsTemperatureDTO weatherForecastItemsTemperatureDTO;

    @JsonProperty("wind")
    public WeatherForecastItemsWindDTO weatherForecastItemsWindDTO;

    @JsonProperty("windchill")
    public WeatherForecastItemsWindChillDTO weatherForecastItemsWindChillDTO;

    @JsonProperty("snowLine")
    public WeatherForecastItemsSnowLineDTO weatherForecastItemsSnowLineDTO;

    @JsonProperty("astronomy")
    public WeatherForecastItemsAstronomyDTO weatherForecastItemsAstronomyDTO;

    public WeatherForecastItemsCloudDTO weatherForecastItemsCloudDTO;
}
