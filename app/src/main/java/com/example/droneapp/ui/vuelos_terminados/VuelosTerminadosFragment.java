package com.example.droneapp.ui.vuelos_terminados;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VuelosTerminadosFragment extends Fragment {


    private FloatingActionButton fab;
    private VuelosTerminadosViewModel vuelosTerminadosViewModel;
    private RecyclerView recyclerViewVuelos;
    private MyAdapter mAdapter;

    Activity activity;
    IComunicaVuelosFragments interfaceComunica;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vuelosTerminadosViewModel =
                ViewModelProviders.of(this).get(VuelosTerminadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vuelos_terminados, container, false);
        recyclerViewVuelos = (RecyclerView) root.findViewById(R.id.recicler_terminar_vuelos);
        recyclerViewVuelos.setLayoutManager(new LinearLayoutManager(getContext()));

        vuelosTerminadosViewModel.getVuelosTerminados().observe(this, new Observer<List<FlightPOJO>>() {
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_crear_vuelo);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            this.activity = (Activity) context;
            this.interfaceComunica = (IComunicaVuelosFragments) this.activity;
        }
    }
}