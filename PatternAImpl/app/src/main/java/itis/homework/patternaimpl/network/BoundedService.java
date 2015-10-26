package itis.homework.patternaimpl.network;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author Artur Vasilov
 */
public class BoundedService extends Service {

    private final IBinder mBinder = new ServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void executeRequest() {
    }

    public class ServiceBinder extends Binder {

        public BoundedService getService() {
            return BoundedService.this;
        }

    }
}


