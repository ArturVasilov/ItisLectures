package ru.samples.itis.clientserver.content;

import com.google.gson.annotations.SerializedName;

/**
 * @author Artur Vasilov
 */
public class Weather {

    @SerializedName("name")
    private String mName;

    @SerializedName("main")
    private MainParams mParams;

    private class MainParams {

        @SerializedName("humidity")
        private int mHumidity;

        @SerializedName("pressure")
        private int mPressure;

        @SerializedName("temp")
        private float mTemperature;

    }

}
