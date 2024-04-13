package com.weather.weatherforecastapplication.services.impl;

import com.weather.weatherforecastapplication.constants.EnvVariables;
import com.weather.weatherforecastapplication.dtos.WeatherErrorDTO;
import com.weather.weatherforecastapplication.dtos.WeatherResponseDTO;
import com.weather.weatherforecastapplication.enums.ForecastTypeEnum;
import com.weather.weatherforecastapplication.services.ForecastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;
import java.time.Duration;
import java.util.Objects;

@Slf4j
@Service
public class ForecastServiceImpl implements ForecastService {

    private final EnvVariables envConstants;

    @Qualifier(value = "WebClient")
    private final WebClient webClient;

    public ForecastServiceImpl(EnvVariables envConstants, WebClient webClient) {
        this.envConstants = envConstants;
        this.webClient = webClient;
    }

    /**
     * @param locationName name of the location to fetch weather data for
     * @return WeatherResponseDTO
     */
    @Override
    public ResponseEntity<WeatherResponseDTO> getForecastSummaryByLocationName(String locationName) {

        long start = System.currentTimeMillis();
        log.info("Fetching Forecast Summary for LocationName :: {}", locationName);

        ResponseEntity<WeatherResponseDTO> summaryWeatherResponseEntity =
                fetchWeatherApiResponse(locationName, ForecastTypeEnum.FORECAST_SUMMARY);

        if (Objects.isNull(summaryWeatherResponseEntity)) {
            log.info("Received NULL for location :: {}", locationName);
            summaryWeatherResponseEntity = populateNullDTO();
        } else {
            long diff = System.currentTimeMillis() - start;
            log.info("Received Summary Forecast Response :: {} for location :: {} in :: {} seconds",
                    summaryWeatherResponseEntity.getStatusCode(), locationName, diff / 1000.0);
        }
        return summaryWeatherResponseEntity;
    }

    /**
     * @param locationName name of the location to fetch weather data for
     * @return WeatherResponseDTO
     */
    @Override
    public ResponseEntity<WeatherResponseDTO> getHourlyForecastByLocationName(String locationName) {

        long start = System.currentTimeMillis();
        log.info("Fetching Hourly Forecast for LocationName :: {}", locationName);

        ResponseEntity<WeatherResponseDTO> hourlyWeatherResponseEntity =
                fetchWeatherApiResponse(locationName, ForecastTypeEnum.FORECAST_HOURLY);

        long diff = System.currentTimeMillis() - start;

        if (Objects.isNull(hourlyWeatherResponseEntity)) {
            log.info("Received NULL for location :: {}", locationName);
            hourlyWeatherResponseEntity = populateNullDTO();
        } else {
            log.info("Received Hourly Forecast Response :: {} for location :: {} in :: {} seconds",
                    hourlyWeatherResponseEntity.getStatusCode(), locationName, diff / 1000.0);
        }
        return hourlyWeatherResponseEntity;
    }

    private ResponseEntity<WeatherResponseDTO> populateNullDTO() {
        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();
        WeatherErrorDTO weatherErrorDTO = new WeatherErrorDTO();
        weatherErrorDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        weatherErrorDTO.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(weatherResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<WeatherResponseDTO> fetchWeatherApiResponse(String locationName, ForecastTypeEnum forecastTypeEnum) {

        String uri = envConstants.getRapidApiBaseUri() + (Objects.equals(forecastTypeEnum, ForecastTypeEnum.FORECAST_HOURLY) ?
                envConstants.getHourlyUriSuffix() :
                envConstants.getSummaryUriSuffix());

        return webClient
                        .get()
                        .uri(uri, locationName)
                        .headers(httpHeaders -> {
                            httpHeaders.set(EnvVariables.FORECAST_API_HEADER_TOKEN_KEY, envConstants.getForecastApiHeaderTokenValue());
                            httpHeaders.set(EnvVariables.FORECAST_API_HEADER_HOST_KEY, envConstants.getForecastApiHeaderHostValue());
                        })
                        .retrieve()
                        .toEntity(WeatherResponseDTO.class)
                        .timeout(Duration.ofSeconds(EnvVariables.REQUEST_TIMEOUT))
                        .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)))
                        .block();
    }
}
