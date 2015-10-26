package itis.homework.patternaimpl.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import itis.homework.patternaimpl.database.contracts.MessageContract;

/**
 * @author Artur Vasilov
 */
public class SqliteHelper extends SQLiteOpenHelper {

    public static final String CONTENT_AUTHORITY = "ru.itis.lectures.db";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String DATABASE_NAME = "ru.itis.lectures.db";

    private static final int DATABASE_VERSION = 1;

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MessageContract.DatabaseRequests.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MessageContract.DatabaseRequests.DROP);
        onCreate(db);
    }
}

