package com.example.droneapp.ui.crear_vuelo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.droneapp.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CrearVueloFragment extends Fragment {

    private CrearVueloViewModel crearVueloViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*
        View root_fab=inflater.inflate(R.layout.app_bar_main,container,false);
        final FloatingActionButton fab = root_fab.findViewById(R.id.fab);
        fab.hide();
         */
        try
        {
            BufferedWriter fout=
                    new BufferedWriter(
                            new FileWriter(
                                    new File("src/main/java/com/example/droneapp/DB/datos_vuelos.txt")));


            crearVueloViewModel =
                    ViewModelProviders.of(this).get(CrearVueloViewModel.class);
            View root = inflater.inflate(R.layout.fragment_crear_vuelo, container, false);
            final Spinner spinner = (Spinner)root.findViewById(R.id.spinner_tipo_camara);

            String escribir="";

            /*Ingresando la fecha actual*/
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = new Date();
            String fecha = dateFormat.format(date);
            final EditText editfecha=(EditText)root.findViewById(R.id.fecha_crear_vuelo);
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
            editfecha.setText(fecha+"  "+hourFormat);


            escribir=escribir+((EditText)root.findViewById(R.id.nombre_crear_vuelo)).getText().toString()+",";/*Obteniendo el nombre del vuelo*/


            /*Obteniendo el Tipo de Camara*/
            crearVueloViewModel.getText().observe(this, new Observer<List<String>>() {
                @Override
                public void onChanged(@Nullable List<String> s) {
                    // Create an ArrayAdapter using the string array and a default spinner layout
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,s);
                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    // Apply the adapter to the spinner
                    spinner.setAdapter(adapter);
                }
            });

            escribir = editfecha.getText().toString()+","; /*obteniendo la fecha*/
            //escribir = ((Spinner)root.findViewById(R.id.spinner_tipo_camara)).getPopupContext().toString();




            /*Se guarda con el siguiente formato  nombre,fecha/hora,es_multiespectral,comentarios*/
            fout.write(escribir);
            fout.close();

            Toast.makeText(getContext(), "Su vuelo se ha creado exitosamente", Toast.LENGTH_LONG).show();
            return root;
        }
        catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
        return null;
    }
}