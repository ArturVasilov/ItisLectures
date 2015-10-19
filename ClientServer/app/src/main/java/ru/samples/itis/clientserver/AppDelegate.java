package ru.samples.itis.clientserver;

import android.app.Application;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author Artur Vasilov
 */
public class AppDelegate extends Application {

    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
    }

    @NonNull
    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}


