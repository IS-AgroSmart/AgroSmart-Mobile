package com.example.droneapp.ui.vuelos_en_procesamiento;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VuelosEnProcesamientoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VuelosEnProcesamientoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Vista de Vuelos en Procesamiento Proximamente...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}