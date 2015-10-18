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

        mRequestsService.config();
        mRequestsService.auth();
        mRequestsService.friends();
        mRequestsService.posts();
        mRequestsService.groups();
        mRequestsService.messages();
        mRequestsService.photos();
    }
}
