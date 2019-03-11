package com.example.week4weekend.model.datasource.remote;

import com.example.week4weekend.model.weather.WeatherResponse;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherResponseRepository {
    private RetroFitHelper retroFitHelper;

    public WeatherResponseRepository() {
        this.retroFitHelper = new RetroFitHelper();
    }

    public void getWeatherResponse(String zip, String appid, WeatherResponseCallback weatherResponseCallback ){
        retroFitHelper.getWeatherResponseObservable(zip, appid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new WeatherResponseObserver(weatherResponseCallback));
    }
}
