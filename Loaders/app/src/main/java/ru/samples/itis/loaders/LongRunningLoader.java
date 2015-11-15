package ru.samples.itis.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.SystemClock;

/**
 * @author Artur Vasilov
 */
public class LongRunningLoader extends AsyncTaskLoader<String> {

    public LongRunningLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        SystemClock.sleep(5_000);
        return "Hello";
    }
}


