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
public class WeatherForecastItemsAstronomyDTO {

    @JsonProperty("dawn")
    public String dawn;

    @JsonProperty("sunrise")
    public String sunrise;

    @JsonProperty("suntransit")
    public String suntransit;

    @JsonProperty("sunset")
    public String sunset;

    @JsonProperty("dusk")
    public String dusk;

    @JsonProperty("moonrise")
    public String moonrise;

    @JsonProperty("moontransit")
    public String moontransit;

    @JsonProperty("moonset")
    public String moonset;

    @JsonProperty("moonphase")
    public Integer moonphase;

    @JsonProperty("moonzodiac")
    public Integer moonzodiac;
}
