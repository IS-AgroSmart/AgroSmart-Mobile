package com.example.droneapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.droneapp.MainActivity;
import com.example.droneapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*Metodo del boton de login */
    public void IniciarSesion(View view){
        Intent Iniciar=new Intent(this, MainActivity.class);
        startActivity(Iniciar); //Iniciando la activity nueva
        String welcome = getString(R.string.welcome) + ((EditText)findViewById(R.id.username)).getText();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }
}
