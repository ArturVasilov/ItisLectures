package ru.samples.itis.clientserver.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import ru.samples.itis.clientserver.content.GsonHolder;
import ru.samples.itis.clientserver.content.Weather;

/**
 * @author Artur Vasilov
 */
public class WeatherService {

    public static String fetchWeather() {
        OkHttpClient client = OkHttp.getClient();
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q=Kazan")
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
            //TODO : parse, display and enjoy
        } catch (IOException e) {
            //TODO : oops
            return "";
        }
    }

    @NonNull
    public static Weather parseWeather(@Nullable String weatherJson) {
        if (TextUtils.isEmpty(weatherJson)) {
            return new Weather();
        }
        return GsonHolder.getGson().fromJson(weatherJson, Weather.class);
    }
}


