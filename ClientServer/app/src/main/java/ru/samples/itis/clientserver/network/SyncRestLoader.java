package ru.samples.itis.clientserver.network;

import android.content.Context;
import android.content.Loader;
import android.database.Cursor;

/**
 * @author Artur Vasilov
 */
public class SyncRestLoader extends Loader<Cursor> {

    public SyncRestLoader(Context context) {
        super(context);
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        //async request
        //save to database
        //query database and call #deliverResult
    }
}


