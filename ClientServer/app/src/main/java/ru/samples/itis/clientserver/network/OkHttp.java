package ru.samples.itis.clientserver.network;

import android.support.annotation.NonNull;

import com.squareup.okhttp.OkHttpClient;

import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

/**
 * @author Artur Vasilov
 */
public class OkHttp {

    private static final int CONNECT_TIMEOUT = 15;
    private static final int WRITE_TIMEOUT = 60;
    private static final int TIMEOUT = 60;

    private static OkHttpClient sHttpClient;

    @NonNull
    public static OkHttpClient getClient() {
        OkHttpClient client = sHttpClient;
        if (client == null) {
            synchronized (OkHttp.class) {
                client = sHttpClient;
                if (client == null) {
                    client = sHttpClient = newClient();
                    client.setCookieHandler(CookieManager.getDefault());
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient newClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        client.setWriteTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        client.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);
        return client;
    }

}
