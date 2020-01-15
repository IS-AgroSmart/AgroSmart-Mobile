package com.example.droneapp.ui.crear_vuelo;

import android.widget.Spinner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrearVueloViewModel extends ViewModel {

    private MutableLiveData<List<String>> mText;
    private MutableLiveData<String> mText_fecha_hora;

    public CrearVueloViewModel() {
        mText = new MutableLiveData<>();
        mText_fecha_hora = new MutableLiveData<>();
        List<String> lista_spinner= new ArrayList<>();
        lista_spinner.add("RGB");
        lista_spinner.add("Red Edge");
        mText.setValue(lista_spinner);

        /*Obteniendo la fecha y hora*/
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        mText_fecha_hora.setValue(hourdateFormat.format(date));
    }

    public LiveData<List<String>> getText() {
        return mText;
    }
    public LiveData<String> getTextFechaHora() {
        return mText_fecha_hora;
    }
}
