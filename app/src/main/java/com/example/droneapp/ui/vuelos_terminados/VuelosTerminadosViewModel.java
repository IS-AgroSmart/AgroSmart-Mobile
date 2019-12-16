package com.example.droneapp.ui.vuelos_terminados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VuelosTerminadosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VuelosTerminadosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esto es vuelos terminados fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}