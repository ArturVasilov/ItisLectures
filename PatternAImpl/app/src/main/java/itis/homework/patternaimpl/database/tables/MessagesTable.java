package itis.homework.patternaimpl.database.tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import itis.homework.patternaimpl.content.Message;
import itis.homework.patternaimpl.database.DatabaseUtils;
import itis.homework.patternaimpl.database.SqliteHelper;
import itis.homework.patternaimpl.database.contracts.MessageContract;

/**
 * @author Artur Vasilov
 */
public class MessagesTable {

    public static final Uri URI = SqliteHelper.BASE_CONTENT_URI
            .buildUpon()
            .appendPath(MessageContract.DatabaseRequests.TABLE_NAME)
            .build();

    public static void save(Context context, @NonNull Message message) {
        context.getContentResolver().insert(URI, toContentValues(message));
    }

    public static void save(Context context, @NonNull List<Message> messages) {
        ContentValues[] values = new ContentValues[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            values[i] = toContentValues(messages.get(i));
        }
        context.getContentResolver().bulkInsert(URI, values);
    }

    @NonNull
    public static ContentValues toContentValues(@NonNull Message message) {
        ContentValues values = new ContentValues();
        values.put(MessageContract.Columns.MESSAGE, message.getMessage());
        return values;
    }

    @NonNull
    public static Message fromCursor(@NonNull Cursor cursor) {
        String message = cursor.getString(cursor.getColumnIndex(MessageContract.Columns.MESSAGE));
        return new Message(message);
    }

    @NonNull
    public static List<Message> listFromCursor(@NonNull Cursor cursor) {
        List<Message> airports = new ArrayList<>();
        if (!cursor.moveToFirst()) {
            return airports;
        }
        try {
            do {
                airports.add(fromCursor(cursor));
            } while (cursor.moveToNext());
            return airports;
        } finally {
            DatabaseUtils.safeCloseCursor(cursor);
        }
    }

    public static void clear(Context context) {
        context.getContentResolver().delete(URI, null, null);
    }

}
