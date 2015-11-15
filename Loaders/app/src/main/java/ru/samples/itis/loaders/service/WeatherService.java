package ru.samples.itis.loaders.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.samples.itis.loaders.BuildConfig;
import ru.samples.itis.loaders.app.Otto;
import ru.samples.itis.loaders.app.WeatherLoadedEvent;
import ru.samples.itis.loaders.weather.ApiFactory;
import ru.samples.itis.loaders.weather.Weather;

/**
 * @author Artur Vasilov
 */
public class WeatherService extends Service {

    public static void start(Context context) {
        Intent intent = new Intent(context, WeatherService.class);
        context.startService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ApiFactory.getWeatherService().weather("Kazan", BuildConfig.API_KEY)
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Response<Weather> response, Retrofit retrofit) {
                        Otto.INSTANCE.post(WeatherLoadedEvent.produce(response.body()));
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
