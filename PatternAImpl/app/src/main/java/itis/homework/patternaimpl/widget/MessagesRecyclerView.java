package itis.homework.patternaimpl.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

import itis.homework.patternaimpl.content.Message;
import itis.homework.patternaimpl.database.DatabaseObserver;
import itis.homework.patternaimpl.database.tables.MessagesTable;

/**
 * @author Artur Vasilov
 */
public class MessagesRecyclerView extends RecyclerView {

    private final ContentObserver mMessagesObserver = new DatabaseObserver() {

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            query();
        }
    };

    private MessagesAdapter mMessagesAdapter;

    public MessagesRecyclerView(Context context) {
        super(context);
        init();
    }

    public MessagesRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MessagesRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        List<Message> messages = new ArrayList<>();
        mMessagesAdapter = new MessagesAdapter(messages);
        setAdapter(mMessagesAdapter);
        query();

        getContext().getContentResolver().registerContentObserver(MessagesTable.URI,
                false, mMessagesObserver);
    }

    @Override
    protected void onDetachedFromWindow() {
        getContext().getContentResolver().unregisterContentObserver(mMessagesObserver);
        super.onDetachedFromWindow();
    }

    private void query() {
        Cursor cursor = getContext().getContentResolver().query(MessagesTable.URI,
                null, null, null, null);
        if (cursor != null) {
            swapAdapter(cursor);
        }
    }

    private void swapAdapter(@NonNull Cursor cursor) {
        List<Message> messages = MessagesTable.listFromCursor(cursor);
        mMessagesAdapter.setMessages(messages);
    }

}
