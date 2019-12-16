package com.example.droneapp.ui.crear_vuelo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrearVueloViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CrearVueloViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esto es Crear vuelo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}