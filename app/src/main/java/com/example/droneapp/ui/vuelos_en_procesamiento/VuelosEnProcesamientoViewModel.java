package com.example.droneapp.ui.vuelos_en_procesamiento;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.droneapp.APIClient.FlightPOJO;

import java.util.List;

public class VuelosEnProcesamientoViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<FlightPOJO>> mVuelos;
    private static List<FlightPOJO> vuelos;

    public VuelosEnProcesamientoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Vista de Vuelos en Procesamiento Proximamente...");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<FlightPOJO>> getVuelosProcesamiento() {
        return mVuelos;
    }

}