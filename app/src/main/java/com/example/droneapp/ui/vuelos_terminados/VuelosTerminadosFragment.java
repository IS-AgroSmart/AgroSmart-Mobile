package com.example.droneapp.ui.vuelos_terminados;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.R;

public class VuelosTerminadosFragment extends Fragment {

    private VuelosTerminadosViewModel vuelosTerminadosViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vuelosTerminadosViewModel =
                ViewModelProviders.of(this).get(VuelosTerminadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vuelos_terminados, container, false);
        final TextView textView = root.findViewById(R.id.textView_nombre_vuelo);

        recyclerView = (RecyclerView) root.findViewById(R.id.recicler_terminar_vuelos);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        String[] lop={"ee","33"};
        mAdapter = new MyAdapter(lop);
        recyclerView.setAdapter(mAdapter);

        /*
        vuelosTerminadosViewModel.getTextNombres().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s[]);
            }
        });*/
        return root;
    }

}