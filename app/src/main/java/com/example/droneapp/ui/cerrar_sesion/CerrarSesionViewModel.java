package com.example.droneapp.ui.cerrar_sesion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CerrarSesionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CerrarSesionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esto es Cerrar Sesion fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}