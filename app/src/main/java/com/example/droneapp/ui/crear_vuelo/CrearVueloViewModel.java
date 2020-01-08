package com.example.droneapp.ui.crear_vuelo;

import android.widget.Spinner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;
import java.util.List;

public class CrearVueloViewModel extends ViewModel {

    private MutableLiveData<List<String>> mText;

    public CrearVueloViewModel() {
        mText = new MutableLiveData<>();
        List<String> lista_spinner= new ArrayList<>();
        lista_spinner.add("RGB");
        lista_spinner.add("Red Edge");
        mText.setValue(lista_spinner);
    }

    public LiveData<List<String>> getText() {
        return mText;
    }
}
