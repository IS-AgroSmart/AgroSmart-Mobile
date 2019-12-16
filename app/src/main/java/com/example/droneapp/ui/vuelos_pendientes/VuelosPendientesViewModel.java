package com.example.droneapp.ui.vuelos_pendientes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VuelosPendientesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VuelosPendientesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esto es Vuelos Pendientes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}