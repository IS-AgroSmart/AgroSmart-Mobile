package com.example.droneapp.ui.crear_vuelo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.droneapp.APIClient.FlightHelper;
import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.APIClient.FlightService;
import com.example.droneapp.APIClient.Flights;
import com.example.droneapp.R;
import com.example.droneapp.ui.login.LoginHelper;
import com.example.droneapp.ui.vuelos_terminados.IComunicaVuelosFragments;
import com.example.droneapp.ui.vuelos_terminados.VuelosTerminadosFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearVueloFragment extends Fragment {

    private CrearVueloViewModel crearVueloViewModel;
    FlightService ApiInterface;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*
        View root_fab=inflater.inflate(R.layout.app_bar_main,container,false);
        final FloatingActionButton fab = root_fab.findViewById(R.id.fab);
        fab.hide();
         */
        crearVueloViewModel =
                ViewModelProviders.of(this).get(CrearVueloViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crear_vuelo, container, false);
        final Spinner spinner = (Spinner) root.findViewById(R.id.spinner_tipo_camara);
        final EditText text_hora = (EditText) root.findViewById(R.id.fecha_crear_vuelo);
        final EditText  nombre = (EditText) root.findViewById(R.id.nombre_crear_vuelo);
        final EditText coments = (EditText) root.findViewById(R.id.id_comentarios);
        final CheckBox multiespectral = (CheckBox) root.findViewById(R.id.multiespectral);

        getActivity().setTitle("Vuelos terminados");

        /*Obteniendo la fecha y hora actual*/
        crearVueloViewModel.getTextFechaHora().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                text_hora.setText(s);
            }
        });


        /*Obteniendo el Tipo de Camara*/
        crearVueloViewModel.getText().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> s) {
                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, s);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                spinner.setAdapter(adapter);
            }
        });

        root.findViewById(R.id.button_crear_vuelo).setOnClickListener(view -> {
            FlightPOJO new_flight = new FlightPOJO();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(FlightHelper.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            FlightService service = retrofit.create(FlightService.class);
            if(!check_list(text_hora, nombre, coments)){
                return;
            }
            createFlight(new_flight,spinner,text_hora, nombre, coments, multiespectral);
            Call<FlightPOJO> call1 = service.createFlight(new_flight);

                    call1.enqueue(new Callback<FlightPOJO>() {
                        @Override
                        public void onResponse(Call<FlightPOJO> call, Response<FlightPOJO> response) {
                            FlightPOJO createResponse = response.body();

                            if (createResponse != null) {
                                Toast.makeText(CrearVueloFragment.super.getContext(), "Vuelo creado", Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(view).navigate(R.id.nav_vuelos_en_procesamiento);
                            }
                            Log.d("Error", "Failure");
                            Log.d("element",response.toString());
                        }

                        @Override
                        public void onFailure(Call<FlightPOJO> call, Throwable t) {
                            Toast.makeText(CrearVueloFragment.super.getContext(), "onFailure called ", Toast.LENGTH_SHORT).show();
                            call.cancel();
                        }
                    });
        });
        return root;
    }


    public void createFlight(FlightPOJO sender, Spinner tipo_camara, EditText fecha_hora, EditText nombre, EditText coments, CheckBox multiespectral){
        String tipo = tipo_camara.getSelectedItem().toString();
        String date = fecha_hora.getText().toString();
        String titulo = nombre.getText().toString();
        String comentarios = coments.getText().toString();
        String state = "WAITING";
        String user = LoginHelper.USER_TOKEN;
        Boolean multi = multiespectral.isChecked();
        sender.setIs_multiespectral(multi);
        sender.setAnnotations(comentarios);
        sender.setCamera(tipo);
        sender.setDate(date);
        sender.setName(titulo);
        sender.setState(state);
        sender.setUuid(user);
    }

    public boolean check_list(EditText fecha_hora, EditText nombre, EditText coments){
        if(TextUtils.isEmpty(fecha_hora.getText())) {
            fecha_hora.setError("Llene este campo");
            return false;
        }
        if(TextUtils.isEmpty(nombre.getText())) {
            nombre.setError("Llene este campo");
            return false;
        }
        if(TextUtils.isEmpty(coments.getText())) {
            coments.setError("Llene este campo");
            return false;
        }
        return true;
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.button_cancelar_crear_vuelo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_vuelos_terminados);
            }
        });
    }

}