package ru.samples.itis.loaders.app;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.otto.Produce;

import ru.samples.itis.loaders.weather.Weather;

/**
 * @author Artur Vasilov
 */
public class WeatherLoadedEvent {

    private final Weather mWeather;

    private WeatherLoadedEvent(@Nullable Weather weather) {
        mWeather = weather;
    }

    @NonNull
    @Produce
    public static WeatherLoadedEvent produce(@Nullable Weather weather) {
        return new WeatherLoadedEvent(weather);
    }

    @Nullable
    public Weather getWeather() {
        return mWeather;
    }
}
