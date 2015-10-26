package itis.homework.simpleservicesample;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

/**
 * @author Artur Vasilov
 */
public class AppRestartService extends BaseService {

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        launchActivity();
        return START_STICKY;
    }

    private void launchActivity() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Context context = AppRestartService.this;
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        }, 5000);
    }
}

