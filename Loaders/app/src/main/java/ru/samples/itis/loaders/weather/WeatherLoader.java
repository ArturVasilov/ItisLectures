package ru.samples.itis.loaders.weather;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;

import retrofit.Call;
import retrofit.Response;
import ru.samples.itis.loaders.BuildConfig;

/**
 * @author Artur Vasilov
 */
public class WeatherLoader extends AsyncTaskLoader<Weather> {

    private final String mQueryString;

    public WeatherLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    public Weather loadInBackground() {
        WeatherService service = ApiFactory.getWeatherService();
        Call<Weather> call = service.weather(mQueryString, BuildConfig.API_KEY);
        try {
            Response<Weather> response = call.execute();
            Weather weather = response.body();
            if (weather != null) {
                return weather;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


