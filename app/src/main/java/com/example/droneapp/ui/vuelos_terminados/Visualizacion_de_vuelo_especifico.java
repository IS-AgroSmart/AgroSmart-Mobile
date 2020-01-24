package com.example.droneapp.ui.vuelos_terminados;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.droneapp.R;

public class Visualizacion_de_vuelo_especifico extends Fragment {

    private VisualizacionDeVueloEspecificoViewModel mViewModel;
    private View rootc;
    public Visualizacion_de_vuelo_especifico(View view) {
        this.rootc=view;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel=ViewModelProviders.of(this).get(VisualizacionDeVueloEspecificoViewModel.class);
        View root=inflater.inflate(R.layout.visualizacion_de_vuelo_especifico_fragment,container,false);
        final TextView text_nombre_vuelo=(TextView)root.findViewById(R.id.textView_nombre_de_vuelos_terminados);
        final TextView text_fecha_de_creacion_vuelo=(TextView)root.findViewById(R.id.textView_fecha_de_vuelos_terminados);
        final TextView text_tiempo_de_procesamiento=(TextView)root.findViewById(R.id.textView_timempo_de_procesamiento_de_vuelos_terminados);
        final TextView text_notas = (TextView)root.findViewById(R.id.textView_notas_de_vuelos_terminados);

        mViewModel.getmNombreVuelo().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        text_nombre_vuelo.setText(s);
                    }
                }
        );
        mViewModel.getmFechaVuelo().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        text_fecha_de_creacion_vuelo.setText(s);
                    }
                }
        );
        mViewModel.getmTiempoVuelo().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        text_tiempo_de_procesamiento.setText(s);
                    }
                }
        );
        mViewModel.getmNotasVuelo().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        text_notas.setText(s);
                    }
                }
        );

        return root;
    }

}
