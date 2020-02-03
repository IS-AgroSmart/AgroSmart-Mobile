package com.example.droneapp.ui.vuelos_terminados;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.droneapp.APIClient.FlightHelper;
import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.APIClient.FlightService;
import com.example.droneapp.ui.login.LoginHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VuelosTerminadosViewModel extends ViewModel {

    private MutableLiveData<List<FlightPOJO>> mVuelos = new MutableLiveData<>();

    public VuelosTerminadosViewModel() {
        crearVuelos();
    }

    public LiveData<List<FlightPOJO>> getVuelosTerminados() {
        return mVuelos;
    }

    //funcion para obtener vuelos
    public void crearVuelos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FlightHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlightService service = retrofit.create(FlightService.class);

        Call<List<FlightPOJO>> flights = service.listFlights(LoginHelper.getToken());
        flights.enqueue(new Callback<List<FlightPOJO>>() {
            @Override
            public void onResponse(Call<List<FlightPOJO>> call, Response<List<FlightPOJO>> response) {
                mVuelos.setValue(FlightHelper.getFinishedFlights(response.body()));
            }

            @Override
            public void onFailure(Call<List<FlightPOJO>> call, Throwable t) {

            }
        });
    }
}
