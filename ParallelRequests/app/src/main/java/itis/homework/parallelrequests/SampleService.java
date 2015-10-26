package itis.homework.parallelrequests;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import itis.homework.parallelrequests.app.AppDelegate;
import itis.homework.parallelrequests.network.RequestsService;

/**
 * @author Artur Vasilov
 */
public class SampleService extends IntentService {

    public static void start(Context context) {
        Intent intent = new Intent(context, SampleService.class);
        context.startService(intent);
    }

    private RequestsService mRequestsService;

    public SampleService() {
        super(SampleService.class.getName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestsService = AppDelegate.get(this).getRequestsService();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mRequestsService.reset();

        //TODO : example for mark 4 from 10. Hmm, or from 100

        new Thread(new Runnable() {
            @Override
            public void run() {
                mRequestsService.config();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mRequestsService.auth();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mRequestsService.friends();
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mRequestsService.posts();
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mRequestsService.groups();
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mRequestsService.messages();
                        mRequestsService.photos();
                    }
                }).start();
            }
        }).start();
    }
}
