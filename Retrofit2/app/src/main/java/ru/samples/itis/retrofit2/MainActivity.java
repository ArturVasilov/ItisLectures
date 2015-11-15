package ru.samples.itis.retrofit2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Call<Weather> call = ApiFactory.getWeatherService().weatherFullUrl(
                "http://api.openweathermap.org/data/2.5/weather",
                "Kazan", BuildConfig.API_KEY);


        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Response<Weather> response, Retrofit retrofit) {
                Weather weather = response.body();
                if (weather != null) {
                    toast(weather.getName());
                } else {
                    ResponseBody body = response.errorBody();
                    //TODO : handle parse error
                }
            }

            @Override
            public void onFailure(Throwable t) {
                toast(t.getMessage());
            }
        });
    }

    private void toast(@NonNull String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    }

}

