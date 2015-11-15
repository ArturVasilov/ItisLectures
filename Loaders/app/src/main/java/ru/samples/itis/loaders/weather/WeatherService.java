package ru.samples.itis.loaders.weather;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Url;

/**
 * @author Artur Vasilov
 */
public interface WeatherService {

    @GET("data/2.5/weather")
    Call<Weather> weather(@Query("q") String query,
                          @Query("appid") String apiKey);

    @GET
    Call<Weather> weatherFullUrl(@Url String url, @Query("q") String query,
                                 @Query("appid") String apiKey);

}


