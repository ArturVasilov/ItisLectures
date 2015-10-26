package itis.homework.simpleservicesample;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * @author Artur Vasilov
 */
public class ToastService extends BaseService {

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        emitToasts();
        return START_STICKY;
    }

    private void emitToasts() {
        for (int i = 0; i < 3; i++) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ToastService.this, "Hello!", Toast.LENGTH_SHORT).show();
                }
            }, i * 5000);
        }
    }
}


