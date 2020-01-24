package com.example.droneapp.ui.vuelos_terminados;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.droneapp.R;

import static com.example.droneapp.R.id.textView_item_fecha_de_creacion;
import static com.example.droneapp.R.id.textView_item_nombre_vuelo;

public class VisualizacionDeVueloEspecificoViewModel extends ViewModel {
    private MutableLiveData<String> mNombreVuelo;
    private MutableLiveData<String> mFechaVuelo;
    private MutableLiveData<String> mTiempoVuelo;
    private MutableLiveData<String> mNotasVuelo;

    public VisualizacionDeVueloEspecificoViewModel(View root){
        mNombreVuelo=new MutableLiveData<>();
        mFechaVuelo=new MutableLiveData<>();
        mTiempoVuelo=new MutableLiveData<>();
        mNotasVuelo=new MutableLiveData<>();

        //obteniendo los datos de los vuelos terminados
        mNombreVuelo.setValue((String) ((TextView)root.findViewById(textView_item_nombre_vuelo)).getText());
        mFechaVuelo.setValue((String) ((TextView)root.findViewById(textView_item_fecha_de_creacion)).getText());
        mTiempoVuelo.setValue(" 16h 40m ");
        mNotasVuelo.setValue("El vuelo se realizo con exito, pero nos picaron las moscas a cada rato...");

    }


    MutableLiveData<String> getmNombreVuelo() {
        return mNombreVuelo;
    }

    public void setmNombreVuelo(MutableLiveData<String> mNombreVuelo) {
        this.mNombreVuelo = mNombreVuelo;
    }

    public MutableLiveData<String> getmFechaVuelo() {
        return mFechaVuelo;
    }

    public void setmFechaVuelo(MutableLiveData<String> mFechaVuelo) {
        this.mFechaVuelo = mFechaVuelo;
    }

    public MutableLiveData<String> getmTiempoVuelo() {
        return mTiempoVuelo;
    }

    public void setmTiempoVuelo(MutableLiveData<String> mTiempoVuelo) {
        this.mTiempoVuelo = mTiempoVuelo;
    }

    public MutableLiveData<String> getmNotasVuelo() {
        return mNotasVuelo;
    }

    public void setmNotasVuelo(MutableLiveData<String> mNotasVuelo) {
        this.mNotasVuelo = mNotasVuelo;
    }
}
