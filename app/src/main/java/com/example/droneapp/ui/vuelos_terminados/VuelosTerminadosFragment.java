package com.example.droneapp.ui.vuelos_terminados;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.R;
import com.example.droneapp.clases.Vuelos;

import java.util.List;

public class VuelosTerminadosFragment extends Fragment {

    private VuelosTerminadosViewModel vuelosTerminadosViewModel;
    private RecyclerView recyclerViewVuelos;
    private RecyclerView.Adapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vuelosTerminadosViewModel =
                ViewModelProviders.of(this).get(VuelosTerminadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vuelos_terminados, container, false);
        recyclerViewVuelos = (RecyclerView) root.findViewById(R.id.recicler_terminar_vuelos);
        recyclerViewVuelos.setLayoutManager(new LinearLayoutManager(getContext()));

        vuelosTerminadosViewModel.getVuelosTerminados().observe(this, new Observer<List<Vuelos>>() {
            @Override
            public void onChanged(@Nullable List<Vuelos> s) {
                mAdapter = new MyAdapter(s);
                recyclerViewVuelos.setAdapter(mAdapter);
            }
        });
        return root;
    }

}