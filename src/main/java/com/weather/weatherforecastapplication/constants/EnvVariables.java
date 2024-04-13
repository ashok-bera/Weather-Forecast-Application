package com.weather.weatherforecastapplication.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource(value = "classpath:application.yml")
public class EnvVariables {
    public static final Integer REQUEST_TIMEOUT = 3;
    public static final Integer REQUEST_RETRIES = 3;
    public static final Integer REQUEST_MIN_BACKOFF = 3;
    public static final String AUTH_HEADER_KEY = "Authentication";
    public static final String FORECAST_API_HEADER_TOKEN_KEY = "X-RapidAPI-Key";
    public static final String FORECAST_API_HEADER_HOST_KEY = "X-RapidAPI-Host";
    public static final String REQUEST_CONTENT_TYPE_HEADER = "application/json";

    @Value("${rapidApi.baseUri}")
    private String rapidApiBaseUri;

    @Value("${rapidApi.summaryUriSuffix}")
    private String summaryUriSuffix;

    @Value("${rapidApi.hourlyUriSuffix}")
    private String hourlyUriSuffix;

    @Value("${rapidApi.headers.apiKey}")
    private String forecastApiHeaderTokenValue;

    @Value("${rapidApi.headers.apiHost}")
    private String forecastApiHeaderHostValue;
}
