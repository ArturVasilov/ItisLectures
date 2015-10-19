package ru.samples.itis.clientserver.network;

import android.os.AsyncTask;

import ru.samples.itis.clientserver.content.Weather;

/**
 * @author Artur Vasilov
 */
public class WeatherAsyncTask extends AsyncTask<Void, Void, Weather> {

    @Override
    protected Weather doInBackground(Void... params) {
        String weatherJson = WeatherService.fetchWeather();
        return WeatherService.parseWeather(weatherJson);
    }

    @Override
    protected void onPostExecute(Weather weather) {
        //TODO : update ui
    }
}




