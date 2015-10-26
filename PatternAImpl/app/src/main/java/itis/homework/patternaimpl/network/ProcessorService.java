package itis.homework.patternaimpl.network;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

/**
 * @author Artur Vasilov
 */
public class ProcessorService extends Service {

    private static final String REQUEST_KEY = "requestId";

    public static void startRequest(Context context, @IdRes int requestId) {
        //add some parameters for your request
        //start service
        Intent intent = new Intent();
        intent.putExtra(REQUEST_KEY, requestId);
        context.startService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int requestId = intent.getIntExtra(REQUEST_KEY, 0);
        //start request according to request id
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


