package com.example.droneapp.ui.vuelos_en_procesamiento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.R;
import com.example.droneapp.ui.vuelos_terminados.IComunicaVuelosFragments;
import com.example.droneapp.ui.vuelos_terminados.MyAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VuelosEnProcesamientoFragment extends Fragment {

    private VuelosEnProcesamientoViewModel vuelosEnProcesamientoViewModel;
    private FloatingActionButton fab;
    private RecyclerView recyclerViewVuelos;
    private MyAdapter mAdapter;
    IComunicaVuelosFragments interfaceComunica;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vuelosEnProcesamientoViewModel =
                ViewModelProviders.of(this).get(VuelosEnProcesamientoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vuelos_en_procesamiento, container, false);
        recyclerViewVuelos = (RecyclerView) root.findViewById(R.id.recicler_terminar_vuelos);
        recyclerViewVuelos.setLayoutManager(new LinearLayoutManager(getContext()));

        vuelosEnProcesamientoViewModel.getVuelosProcesamiento().observe(this, new Observer<List<FlightPOJO>>() {
            @Override
            public void onChanged(@Nullable final List<FlightPOJO> s) {
                mAdapter = new MyAdapter(s);
                recyclerViewVuelos.setAdapter(mAdapter);
                mAdapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        interfaceComunica.enviarVuelo((FlightPOJO) s
                                .get(recyclerViewVuelos.getChildAdapterPosition(v)));

                        Toast.makeText(getContext(), "Seleccionado: " + s
                                .get(recyclerViewVuelos.getChildAdapterPosition(v)).getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return root;
    }
}