package com.example.droneapp.APIClient;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface FlightService {

    String API_ROUTE = "/api/flights/";

    @GET("flights")
    Call<List<FlightPOJO>> listFlights(@Header("Authorization") String token);

    @GET(API_ROUTE)
    Call<FlightPOJO> showFlight(@Path("uid") String uuid);

    @POST("flights")
    Call<FlightPOJO> createFlight(@Body FlightPOJO flight);

    @PUT(API_ROUTE+"{uid}")
    Call<FlightPOJO> updateFlight(@Path("uid") String uuid, @Body FlightPOJO flight);



}
