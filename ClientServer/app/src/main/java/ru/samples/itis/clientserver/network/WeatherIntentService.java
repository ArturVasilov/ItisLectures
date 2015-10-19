package ru.samples.itis.clientserver.network;

import android.app.IntentService;
import android.content.Intent;

import ru.samples.itis.clientserver.content.Weather;

/**
 * @author Artur Vasilov
 */
public class WeatherIntentService extends IntentService {

    public WeatherIntentService() {
        super(WeatherIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String weatherJson = WeatherService.fetchWeather();
        Weather weather = WeatherService.parseWeather(weatherJson);
    }
}

