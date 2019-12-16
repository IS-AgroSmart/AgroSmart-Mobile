package com.example.droneapp.ui.crear_vuelo;

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

import com.example.droneapp.R;

public class CrearVueloFragment extends Fragment {

    private CrearVueloViewModel crearVueloViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        crearVueloViewModel =
                ViewModelProviders.of(this).get(CrearVueloViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crear_vuelo, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        crearVueloViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}