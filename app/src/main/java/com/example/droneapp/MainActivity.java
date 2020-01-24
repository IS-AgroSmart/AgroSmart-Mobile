package com.example.droneapp;

import android.os.Bundle;

import com.example.droneapp.ui.crear_vuelo.CrearVueloFragment;
import com.example.droneapp.ui.vuelos_terminados.Visualizacion_de_vuelo_especifico;
import com.example.droneapp.ui.vuelos_terminados.VuelosTerminadosFragment;
import com.example.droneapp.ui.vuelos_terminados.VuelosTerminadosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);


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

        VuelosTerminadosFragment vuelos_t=new VuelosTerminadosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,vuelos_t);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavController navController = Navigation.findNavController(getParent(), R.id.nav_crear_vuelo);
                //NavigationUI.navigateUp(navController,mAppBarConfiguration);
                /*
                CrearVueloFragment ct=new CrearVueloFragment();
                //getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).commit();
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.nav_host_fragment,ct).commit();
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                 */
            }
        });
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

    public void onClick_vuelos_terminados(View view){
        Visualizacion_de_vuelo_especifico vuelo_especifico=new Visualizacion_de_vuelo_especifico(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,vuelo_especifico).commit();

    }
}
