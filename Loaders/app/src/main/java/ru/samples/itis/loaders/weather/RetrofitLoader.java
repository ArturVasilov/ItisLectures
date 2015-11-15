package ru.samples.itis.loaders.weather;

import android.content.Context;
import android.content.Loader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.samples.itis.loaders.BuildConfig;

/**
 * @author Artur Vasilov
 */
public class RetrofitLoader extends Loader<Weather> {

    private final Call<Weather> mCall;

    public RetrofitLoader(Context context) {
        super(context);
        mCall = ApiFactory.getWeatherService().weather("Kazan", BuildConfig.API_KEY);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        mCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Response<Weather> response, Retrofit retrofit) {
                deliverResult(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                deliverResult(null);
            }
        });
    }

    @Override
    protected boolean onCancelLoad() {
        mCall.cancel();
        return true;
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    public void reset() {
        super.reset();
    }
}
