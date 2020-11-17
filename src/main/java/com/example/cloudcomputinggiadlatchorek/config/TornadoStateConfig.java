package com.example.cloudcomputinggiadlatchorek.config;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Getter
@Configuration
public class TornadoStateConfig {

    @Value("${LOCATION}")
    private String location;

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${units}")
    private String units;

    public String getApiURL(){
        return String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s&units=%s",
                location, apiKey, units);
    };
}
