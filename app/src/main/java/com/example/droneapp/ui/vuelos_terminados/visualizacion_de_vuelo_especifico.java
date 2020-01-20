package com.example.droneapp.ui.vuelos_terminados;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.droneapp.R;

public class visualizacion_de_vuelo_especifico extends Fragment {

    private VisualizacionDeVueloEspecificoViewModel mViewModel;

    public static visualizacion_de_vuelo_especifico newInstance() {
        return new visualizacion_de_vuelo_especifico();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.visualizacion_de_vuelo_especifico_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VisualizacionDeVueloEspecificoViewModel.class);
        // TODO: Use the ViewModel
    }

}
