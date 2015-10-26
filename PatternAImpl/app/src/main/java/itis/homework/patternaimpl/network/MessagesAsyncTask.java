package itis.homework.patternaimpl.network;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import itis.homework.patternaimpl.content.Message;
import itis.homework.patternaimpl.database.DatabaseUtils;
import itis.homework.patternaimpl.database.tables.MessagesTable;

/**
 * @author Artur Vasilov
 */
public class MessagesAsyncTask extends AsyncTask<Void, Void, Void> {

    private final Context mContext;

    public MessagesAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        if (!DatabaseUtils.isUriEmpty(mContext, MessagesTable.URI)) {
            //show the idea that downloading will be completed even if user has closed the application
            return null;
        }

        //e.g. downloading with pagination
        Random random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            //some download process here
            SystemClock.sleep((random.nextInt(5) + 1) * 1000);

            final int step = i + 1;
            List<Message> messages = new ArrayList<Message>() {{
                add(new Message(String.format("\n\nDownload step number %d", step)));
                add(new Message("Hello"));
                add(new Message("New message goes here"));
                add(new Message("Oh, I don't have an ideas for new message"));
                add(new Message("Loran ipsum,.. loren ipsum, yep, that's correct"));
                add(new Message("So, I believe you understood the idea"));
            }};

            MessagesTable.save(mContext, messages);
            mContext.getContentResolver().notifyChange(MessagesTable.URI, null);
        }
        return null;
    }
}


