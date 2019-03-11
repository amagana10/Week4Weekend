package com.example.week4weekend.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.week4weekend.R;
import com.example.week4weekend.model.datasource.remote.WeatherResponseCallback;
import com.example.week4weekend.model.datasource.remote.WeatherResponseRepository;
import com.example.week4weekend.model.weather.WeatherResponse;

public class MainActivity extends AppCompatActivity implements WeatherResponseCallback {
    TextView tvweather;
    EditText etZipCode;
    WeatherResponseRepository weatherResponseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvweather = findViewById(R.id.tvWeather);
        etZipCode = findViewById(R.id.etZipcode);

        weatherResponseRepository = new WeatherResponseRepository();
    }

    @Override
    public void OnSuccess(WeatherResponse weatherResponse) {
        tvweather.setText("Weather: "+ weatherResponse.getWeather().get(0).getDescription());

    }

    public void onClick(View view) {
        String zip = etZipCode.getText()!=null?etZipCode.getText().toString():"60639";
        weatherResponseRepository.getWeatherResponse(zip,"1ee28515bae1fee5d7ac286938be217f",this);

    }
}
