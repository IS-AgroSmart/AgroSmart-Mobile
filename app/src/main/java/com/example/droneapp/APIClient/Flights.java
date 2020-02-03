package com.example.droneapp.APIClient;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.droneapp.ui.login.LoginHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Flights implements Callback<List<FlightPOJO>> {

    static final String BASE_URL = "URL_BASE_DJANGO_SERVER";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FlightService callFlights = retrofit.create(FlightService.class);

        Call<List<FlightPOJO>> call = callFlights.listFlights(LoginHelper.getToken());
        call.enqueue(this);

    }

    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<List<FlightPOJO>> call, Response<List<FlightPOJO>> response) {
        if (response.isSuccessful()) {
            List<FlightPOJO> FlightList = response.body();
            FlightList.forEach(new Consumer<FlightPOJO>() {
                @Override
                public void accept(FlightPOJO flight) {
                    System.out.println(flight);
                }
            });
        } else {
            System.out.println(response.errorBody());
        }
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<List<FlightPOJO>> call, Throwable t) {
        t.printStackTrace();
    }
}
