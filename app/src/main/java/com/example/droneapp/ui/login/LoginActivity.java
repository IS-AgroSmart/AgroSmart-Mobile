package com.example.droneapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.droneapp.APIClient.FlightHelper;
import com.example.droneapp.MainActivity;
import com.example.droneapp.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements LoginTaskResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    /*Metodo del boton de login */
    public void IniciarSesion(View view) {
        String username = ((TextView) findViewById(R.id.username)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();

        new LoginTask(this).execute(username, password);
    }

    @Override
    public void processFinish(String output) {
        LoginHelper.USER_TOKEN = output;
        runOnUiThread(() -> Toast.makeText(this, "Welcome " + output, Toast.LENGTH_SHORT).show());
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
