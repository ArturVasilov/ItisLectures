package ru.samples.itis.clientserver;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import ru.samples.itis.clientserver.content.Weather;
import ru.samples.itis.clientserver.network.WeatherLoader;
import ru.samples.itis.clientserver.network.WeatherService;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Weather> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .remove(new RetainFragment(), )

        //region thread, asynctask
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String weatherJson = WeatherService.fetchWeather();
                Weather weather = WeatherService.parseWeather(weatherJson);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TODO : update UI
                    }
                });
            }
        };
        //new Thread(runnable).start();

        //new WeatherAsyncTask().execute();
        //endregion

        //startService(new Intent(this, WeatherIntentService.class));

        //getLoaderManager().initLoader(R.id.weather_loader, Bundle.EMPTY, this);

        //makeVolleyRequest();

        makeRxRequest();
    }

    private void makeRxRequest() {
        Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(WeatherService.fetchWeather());
            }
        }).flatMap(new Func1<String, Observable<Weather>>() {
            @Override
            public Observable<Weather> call(String s) {
                return Observable.just(WeatherService.parseWeather(s));
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .cache()
                .subscribe(new Action1<Weather>() {
                    @Override
                    public void call(Weather weather) {
                        //TODO : display weather
                    }
                });
    }

    private void makeVolleyRequest() {
        Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //TODO : display
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO : react on error
            }
        };

        JsonObjectRequest request = new JsonObjectRequest("http://api.openweathermap.org/data/2.5/weather?q=Kazan",
                successListener, errorListener);

        ((AppDelegate) getApplication()).getRequestQueue().add(request);
    }

    @Override
    public Loader<Weather> onCreateLoader(int id, Bundle args) {
        if (id == R.id.weather_loader) {
            return new WeatherLoader(this);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Weather> loader, Weather data) {
        if (loader.getId() == R.id.weather_loader) {
            //TODO : display data
        }
    }

    @Override
    public void onLoaderReset(Loader<Weather> loader) {

    }
}

