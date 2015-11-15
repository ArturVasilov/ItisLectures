package ru.samples.itis.loaders;

import android.content.Context;
import android.content.Loader;

import java.util.ArrayList;
import java.util.List;

import ru.samples.itis.loaders.weather.Weather;
import ru.samples.itis.loaders.weather.WeatherLoader;

/**
 * @author Artur Vasilov
 */
public class MultiWeatherLoader extends Loader<List<Weather>>
        implements Loader.OnLoadCompleteListener<Weather> {

    private static final int REQUESTS_COUNT = 2;

    private final List<Weather> mWeatherList;
    private int mRequestsFinished;

    public MultiWeatherLoader(Context context) {
        super(context);
        mWeatherList = new ArrayList<>();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        mRequestsFinished = 0;
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        Loader<Weather> moscow = new WeatherLoader(getContext(), "Moscow");
        Loader<Weather> kazan = new WeatherLoader(getContext(), "Kazan");

        moscow.registerListener(R.id.weather_loader, this);
        moscow.startLoading();

        kazan.registerListener(R.id.weather_loader + 1, this);
        kazan.startLoading();
    }

    @Override
    public void onLoadComplete(Loader<Weather> loader, Weather data) {
        mWeatherList.add(data);
        mRequestsFinished++;
        if (mRequestsFinished >= REQUESTS_COUNT) {
            deliverResult(mWeatherList);
        }
    }
}

