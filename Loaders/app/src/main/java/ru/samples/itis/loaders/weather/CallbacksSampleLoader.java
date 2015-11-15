package ru.samples.itis.loaders.weather;

import android.content.Context;
import android.content.Loader;

/**
 * @author Artur Vasilov
 */
public class CallbacksSampleLoader extends Loader<Weather> {

    public CallbacksSampleLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(Weather data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Override
    public boolean cancelLoad() {
        return super.cancelLoad();
    }

    @Override
    protected boolean onCancelLoad() {
        return super.onCancelLoad();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }

    @Override
    public void forceLoad() {
        super.forceLoad();
    }

    @Override
    public void stopLoading() {
        super.stopLoading();
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }
}
