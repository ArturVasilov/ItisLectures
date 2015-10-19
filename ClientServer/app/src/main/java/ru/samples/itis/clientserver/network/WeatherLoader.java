package ru.samples.itis.clientserver.network;

import android.content.AsyncTaskLoader;
import android.content.Context;

import ru.samples.itis.clientserver.content.Weather;

/**
 * @author Artur Vasilov
 */
public class WeatherLoader extends AsyncTaskLoader<Weather> {

    public WeatherLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Weather loadInBackground() {
        String weatherJson = WeatherService.fetchWeather();
        return WeatherService.parseWeather(weatherJson);
    }
}


