package com.example.droneapp.ui.vuelos_terminados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VuelosTerminadosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VuelosTerminadosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Vista de Vuelos Terminados Proximamente...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}