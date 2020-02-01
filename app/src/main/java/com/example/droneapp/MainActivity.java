package com.example.droneapp;

import android.os.Bundle;

import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.ui.vuelos_terminados.IComunicaVuelosFragments;
import com.example.droneapp.ui.vuelos_terminados.Visualizacion_de_un_vuelo_especifico;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity implements IComunicaVuelosFragments {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_crear_vuelo, R.id.nav_vuelos_terminados, R.id.nav_vuelos_en_procesamiento,
                R.id.nav_vuelos_pendientes, R.id.nav_cerrar_sesion)
                .setDrawerLayout(drawer)
                .build();
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void enviarVuelo(FlightPOJO vuelo) {
        Visualizacion_de_un_vuelo_especifico vuelo_especifico = new Visualizacion_de_un_vuelo_especifico();
        Bundle bundle = new Bundle();
        bundle.putSerializable("objeto", vuelo);
        vuelo_especifico.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor_fragment, vuelo_especifico).addToBackStack(null).commit();
    }
}
