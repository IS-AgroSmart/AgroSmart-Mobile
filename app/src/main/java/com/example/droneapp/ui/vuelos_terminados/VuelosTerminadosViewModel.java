package com.example.droneapp.ui.vuelos_terminados;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.APIClient.FlightService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VuelosTerminadosViewModel extends ViewModel {

    private MutableLiveData<List<FlightPOJO>> mVuelos;
    private static List<FlightPOJO> vuelos;

    public VuelosTerminadosViewModel() {
        /*Aqui se añadiran los nombres y las descripciones de los Vuelos terminados*/
        mVuelos = new MutableLiveData<>();
        crearVuelos();
        mVuelos.setValue(vuelos);
    }

    public LiveData<List<FlightPOJO>> getVuelosTerminados() {
        return mVuelos;
    }

    //funcion para obtener vuelos
    public void crearVuelos() {
        /*Obteniendo la fecha y hora*/
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = hourdateFormat.format(date);
        vuelos = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://391b5808-8024-4864-bda1-992db1ce4e6a.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlightService service = retrofit.create(FlightService.class);
        Log.d("FLIGHTS", "crearVuelos: ");

        Call<List<FlightPOJO>> flights = service.listFlights();
        flights.enqueue(new Callback<List<FlightPOJO>>() {
            @Override
            public void onResponse(Call<List<FlightPOJO>> call, Response<List<FlightPOJO>> response) {
                Log.d("FLIGHTS", "crearVuelos: " + response.body());
                List<FlightPOJO> tmp = response.body();

                for (FlightPOJO c : tmp) {
                    if (c.getState().equals("COMPLETE")) {
                        vuelos.add(c);
                    }
                }
                mVuelos.setValue(vuelos);
            }

            @Override
            public void onFailure(Call<List<FlightPOJO>> call, Throwable t) {

            }
        });
    }
}
