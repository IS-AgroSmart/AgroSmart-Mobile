package com.example.droneapp.ui.vuelos_en_procesamiento;

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

public class VuelosEnProcesamientoFragment extends Fragment {

    private VuelosEnProcesamientoViewModel vuelosEnProcesamientoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vuelosEnProcesamientoViewModel =
                ViewModelProviders.of(this).get(VuelosEnProcesamientoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vuelos_en_procesamiento, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        vuelosEnProcesamientoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}