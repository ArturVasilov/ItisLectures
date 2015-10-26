package itis.homework.patternaimpl;

import android.app.Application;
import android.support.annotation.NonNull;

import itis.homework.patternaimpl.network.Processor;

/**
 * @author Artur Vasilov
 */
public class AppDelegate extends Application {

    private Processor mProcessor;

    @Override
    public void onCreate() {
        super.onCreate();
        mProcessor = new Processor(this);
    }

    @NonNull
    public Processor getProcessor() {
        return mProcessor;
    }
}


