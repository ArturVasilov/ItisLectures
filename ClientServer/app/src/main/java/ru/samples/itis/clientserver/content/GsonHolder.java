package ru.samples.itis.clientserver.content;

import com.google.gson.Gson;

/**
 * @author Artur Vasilov
 */
public class GsonHolder {

    private static final Gson GSON = new Gson();

    public static Gson getGson() {
        return GSON;
    }
}
