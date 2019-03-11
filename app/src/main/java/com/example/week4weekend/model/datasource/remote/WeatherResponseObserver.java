package com.example.week4weekend.model.datasource.remote;

import android.util.Log;

import com.example.week4weekend.model.weather.WeatherResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class WeatherResponseObserver implements Observer<WeatherResponse> {
    private static final String TAG = "TAG_OBSERVER";

    WeatherResponse returnWeatherResponse;
    WeatherResponseCallback weatherResponseCallback;

    public WeatherResponseObserver(WeatherResponseCallback weatherResponseCallback) {
        this.weatherResponseCallback = weatherResponseCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: SUBSCRIBED TO OBSERVABLE");
    }

    @Override
    public void onNext(WeatherResponse weatherResponse) {
        Log.d(TAG, "onNext: RESPONSE RECEIVED ");
        returnWeatherResponse = weatherResponse;
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: ERROR RETURNED", e);
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: TASK IS COMPLETE RETURNING USER RESPONSE");

        weatherResponseCallback.OnSuccess(returnWeatherResponse);

    }
}