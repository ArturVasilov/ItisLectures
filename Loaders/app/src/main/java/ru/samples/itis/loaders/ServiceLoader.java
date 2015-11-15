package ru.samples.itis.loaders;

import android.content.Context;
import android.content.Loader;

import com.squareup.otto.Subscribe;

import ru.samples.itis.loaders.app.Otto;
import ru.samples.itis.loaders.app.WeatherLoadedEvent;
import ru.samples.itis.loaders.service.WeatherService;
import ru.samples.itis.loaders.weather.Weather;

/**
 * @author Artur Vasilov
 */
public class ServiceLoader extends Loader<Weather> {

    private boolean mIsLoadingStarted = false;

    public ServiceLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Otto.INSTANCE.register(this);
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        Otto.INSTANCE.unregister(this);
        super.onStopLoading();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        if (!mIsLoadingStarted) {
            mIsLoadingStarted = true;
            WeatherService.start(getContext());
        }
    }

    @Subscribe
    public void onWeatherLoaded(WeatherLoadedEvent event) {
        deliverResult(event.getWeather());
    }
}

