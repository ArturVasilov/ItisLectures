package itis.homework.patternaimpl.content;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * @author Artur Vasilov
 */
public class Message {

    private final String mMessage;

    public Message(String message) {
        mMessage = message;
    }

    @NonNull
    public String getMessage() {
        return TextUtils.isEmpty(mMessage) ? "" : mMessage;
    }
}


