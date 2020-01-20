package com.example.droneapp.ui.vuelos_terminados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.R;
import com.example.droneapp.clases.Vuelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VuelosTerminadosViewModel extends ViewModel {

    private MutableLiveData<List<Vuelos>> mVuelos;
    private List<Vuelos> vuelos;

    public VuelosTerminadosViewModel() {
        /*Aqui se añadiran los nombres y las descripciones de los Vuelos terminados*/
        mVuelos=new MutableLiveData<>();
        vuelos=obtenerVuelos();
        mVuelos.setValue(vuelos);
    }

    public LiveData<List<Vuelos>> getVuelosTerminados() {
        return mVuelos;
    }

    //funcion para obtener vuelos
    public List<Vuelos> obtenerVuelos() {
        /*Obteniendo la fecha y hora*/
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha=hourdateFormat.format(date);
        vuelos = new ArrayList<>();
        vuelos.add(new Vuelos("Campo de maiz",fecha, "Micasense Red Egde M"));
        vuelos.add(new Vuelos("Campo de arroz", fecha,"Cuidado con las moscas"));
        vuelos.add(new Vuelos("Campo politecnico",fecha, "Don't kill dog on the streets"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));
        vuelos.add(new Vuelos("Campo de verde",fecha, "The best friend of the men"));

        return vuelos;
    }
}
