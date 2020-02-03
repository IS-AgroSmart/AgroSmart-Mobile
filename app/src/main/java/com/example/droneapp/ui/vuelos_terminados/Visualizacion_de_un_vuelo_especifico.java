package com.example.droneapp.ui.vuelos_terminados;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.droneapp.APIClient.FlightPOJO;
import com.example.droneapp.R;
import com.example.droneapp.ui.ortomosaico.ortomosaico;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Visualizacion_de_un_vuelo_especifico.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link //Visualizacion_de_un_vuelo_especifico#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Visualizacion_de_un_vuelo_especifico extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnFragmentInteractionListener mListener;

    public Visualizacion_de_un_vuelo_especifico() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param //param1 Parameter 1.
     * @param //param2 Parameter 2.
     * @return A new instance of fragment Visualizacion_de_un_vuelo_especifico.
     * <p>
     * // TODO: Rename and change types and number of parameters
     * public static Visualizacion_de_un_vuelo_especifico newInstance(String param1, String param2) {
     * Visualizacion_de_un_vuelo_especifico fragment = new Visualizacion_de_un_vuelo_especifico();
     * Bundle args = new Bundle();
     * args.putString(ARG_PARAM1, param1);
     * args.putString(ARG_PARAM2, param2);
     * fragment.setArguments(args);
     * return fragment;
     * }
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootf = inflater.inflate(R.layout.fragment_visualizacion_de_un_vuelo_especifico, container, false);
        final TextView text_nombre_vuelo = (TextView) rootf.findViewById(R.id.textView_nombre_de_vuelos_terminados);
        final TextView text_fecha_de_creacion_vuelo = (TextView) rootf.findViewById(R.id.textView_fecha_de_vuelos_terminados);
        final TextView text_tiempo_de_procesamiento = (TextView) rootf.findViewById(R.id.textView_timempo_de_procesamiento_de_vuelos_terminados);
        final TextView text_notas = (TextView) rootf.findViewById(R.id.textView_notas_de_vuelos_terminados);

        Bundle vuelo_obtenido = getArguments();
        FlightPOJO objetoVuelo = null;

        if (vuelo_obtenido != null) {
            objetoVuelo = (FlightPOJO) vuelo_obtenido.getSerializable("objeto");
            text_nombre_vuelo.setText(objetoVuelo.getName());
            text_fecha_de_creacion_vuelo.setText(objetoVuelo.getDate());
            text_tiempo_de_procesamiento.setText("" + objetoVuelo.getProcessing_time());
            text_notas.setText(objetoVuelo.getAnnotations());
        }

        return rootf;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_vuelo_especifico_ortomosaico);
            }
        });
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
