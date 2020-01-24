package com.example.droneapp.ui.cerrar_sesion;

import android.content.Intent;
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

import com.example.droneapp.MainActivity;
import com.example.droneapp.R;
import com.example.droneapp.ui.login.LoginActivity;

public class CerrarSesionFragment extends Fragment {

    private CerrarSesionViewModel cerrarSesionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cerrarSesionViewModel =ViewModelProviders.of(this).get(CerrarSesionViewModel.class);
        //View root = inflater.inflate(R.layout.activity_login, container, false);
        Intent Iniciar=new Intent(getContext(), LoginActivity.class);
        startActivity(Iniciar); //Iniciando la activity nueva
        return null;
    }
}