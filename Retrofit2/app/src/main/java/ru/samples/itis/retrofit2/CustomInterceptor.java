package ru.samples.itis.retrofit2;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author Artur Vasilov
 */
public class CustomInterceptor implements Interceptor {

    private static final String TAG = CustomInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.i(TAG, "request url: " + request.urlString());
        return chain.proceed(request);
    }
}


