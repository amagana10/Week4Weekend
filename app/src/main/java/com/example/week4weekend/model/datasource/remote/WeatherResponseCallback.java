package com.example.week4weekend.model.datasource.remote;

import com.example.week4weekend.model.weather.WeatherResponse;

public interface WeatherResponseCallback {
    void  OnSuccess(WeatherResponse weatherResponse);
}
