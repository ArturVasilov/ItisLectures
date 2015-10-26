package itis.homework.patternaimpl.network;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author Artur Vasilov
 */
public class MessagesService extends Service {

    public static void start(Context context) {
        Intent intent = new Intent(context, MessagesService.class);
        context.startService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new MessagesAsyncTask(this).execute();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


