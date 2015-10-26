package itis.homework.patternaimpl.network;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.widget.Toast;

import itis.homework.patternaimpl.AppDelegate;

/**
 * @author Artur Vasilov
 */
public class Processor {

    private BoundedService mService;

    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((BoundedService.ServiceBinder) service).getService();
            Toast.makeText(mContext, "Bounded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
            Toast.makeText(mContext, "Unbounded", Toast.LENGTH_SHORT).show();
        }
    };

    private Context mContext;

    @NonNull
    public static Processor get(Context context) {
        return ((AppDelegate) context.getApplicationContext()).getProcessor();
    }

    public Processor(Context context) {
        mContext = context;
    }

    public void executeRequest() {
        if (mService != null) {
            mService.executeRequest();
        } else {
            //add request to queue
            bindService();
        }
    }

    public void bindService() {
        Intent intent = new Intent(mContext, BoundedService.class);
        mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
}
