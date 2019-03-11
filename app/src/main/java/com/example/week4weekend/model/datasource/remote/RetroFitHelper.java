package com.example.week4weekend.model.datasource.remote;

import com.example.week4weekend.model.weather.WeatherResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetroFitHelper {
    private static OkHttpClient getOkHttpClientWithIntercepter() {
        //Declare Interceptor for http logging
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //Set http logging level
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //return new OkHttp Client with interceptor attached
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    private static Retrofit getRetrofit() {
        //Build retrofit instance
        return new Retrofit
                .Builder()
                .baseUrl(ApiConstants.BASE_URL) //Base URL of the api source
                .client(getOkHttpClientWithIntercepter()) //add new okhttp client with interceptor
                .addConverterFactory(GsonConverterFactory.create())// add object converter factory
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build(); //build the instance
    }

    private ObservableInterface createWeatherResponseInterface(){
        return  getRetrofit().create(ObservableInterface.class);
    }

    public  Observable<WeatherResponse> getWeatherResponseObservable(String zip, String appid){
        return createWeatherResponseInterface().getWeatherResponseObservable(zip,appid);
    }


    public  interface ObservableInterface{
        @GET(ApiConstants.PATH_API)
        Observable<WeatherResponse> getWeatherResponseObservable(
                @Query(ApiConstants.QUERY_ZIP) String zip,
                @Query(ApiConstants.QUERY_ID) String appid);
    }


}
