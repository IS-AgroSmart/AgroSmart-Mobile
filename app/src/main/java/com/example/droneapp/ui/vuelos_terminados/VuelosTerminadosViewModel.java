package com.example.droneapp.ui.vuelos_terminados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.R;

import java.util.ArrayList;
import java.util.List;

public class VuelosTerminadosViewModel extends ViewModel {

    private MutableLiveData<List<String>> mTextNombres;
    private MutableLiveData<List<String>> mText2Descripciones;

    public VuelosTerminadosViewModel() {

        /*Aqui se añadiran los nombres y las descripciones de los vuelos terminados*/
        mTextNombres = new MutableLiveData<>();
        List<String> mText= new ArrayList<>();
        mText.add("RGB");
        mText.add("Red Edge");
        mTextNombres.setValue(mText);

        mText2Descripciones = new MutableLiveData<>();
        List<String> mText2= new ArrayList<>();
        mText2.add("RGB2");
        mText2.add("Red Edge2");
        mText2Descripciones.setValue(mText2);
    }

    public LiveData<List<String>> getTextNombres() {
        return mTextNombres;
    }
    public LiveData<List<String>> getTextDescripciones() {
        return mText2Descripciones;
    }
}