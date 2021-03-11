package toan.bui.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterface {
    @GET("forecasts/v1/hourly/12hour/353412")
    Call<List<AccuDatum>> getWeather(
            @Query("apikey") String apikey,
            @Query("language") String language,
            @Query("metric") String metric
    );
    //@GET("https://dataservice.accuweather.com/forecasts/v1/hourly/12hour/353412?apikey=93Qg780lHwYM4SO58n7DFPLqHg4oKADn&language=vi-vn&metric=true")
    //Call<Void> get();
}
