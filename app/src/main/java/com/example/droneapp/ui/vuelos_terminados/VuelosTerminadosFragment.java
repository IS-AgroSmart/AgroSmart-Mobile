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

import com.example.droneapp.R;

public class VuelosTerminadosFragment extends Fragment {

    private VuelosTerminadosViewModel vuelosTerminadosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vuelosTerminadosViewModel =
                ViewModelProviders.of(this).get(VuelosTerminadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vuelos_terminados, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        vuelosTerminadosViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}