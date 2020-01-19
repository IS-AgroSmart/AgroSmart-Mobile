package com.example.droneapp.APIClient;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface FetchFlights {

    String API_ROUTE = "/api/flights/";

    @GET(API_ROUTE)
    Call<List<FlightPOJO>> listFlights();

    @GET(API_ROUTE)
    Call<FlightPOJO> showFlight(@Path("uid") String uuid);

    @POST(API_ROUTE+"new")
    Call<FlightPOJO> createFlight(@Body Flights flight);

    @PUT(API_ROUTE+"{uid}")
    Call<FlightPOJO> updateFlight(@Path("uid") String uuid, @Body Flights flight);



}
