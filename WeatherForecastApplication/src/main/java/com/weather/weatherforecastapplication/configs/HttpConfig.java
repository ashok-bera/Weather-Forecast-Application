package com.weather.weatherforecastapplication.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class HttpConfig {

    @Bean(name = "WebClient")
    public WebClient getHttpBuilder() {
        return WebClient.create();
    }
}
