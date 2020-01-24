package com.example.droneapp.ui.vuelos_terminados;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droneapp.R;
import com.example.droneapp.clases.Vuelos;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
implements View.OnClickListener{

    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if(this.listener!=null){
            listener.onClick(v);
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView_nombre_vuelo;
        public TextView textView_fecha_creacion;
        public TextView textView_descripcion_vuelo;

        public MyViewHolder(View view) {
            super(view);
            textView_nombre_vuelo= (TextView) view.findViewById(R.id.textView_item_nombre_vuelo);
            textView_fecha_creacion= (TextView) view.findViewById(R.id.textView_item_fecha_de_creacion);
            textView_descripcion_vuelo=(TextView) view.findViewById(R.id.textView_item_descripcion_vuelo);
        }
    }

    private List<Vuelos> listVuelos;

    public MyAdapter(List<Vuelos> ListVuelos) {
        this.listVuelos = ListVuelos;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_vuelos_terminados, parent, false);
        MyAdapter.MyViewHolder viewHolder = new MyAdapter.MyViewHolder(view);

        view.setOnClickListener(this);

        return viewHolder;
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView_nombre_vuelo.setText(listVuelos.get(position).getNombre());
        holder.textView_fecha_creacion.setText(listVuelos.get(position).getFecha_de_creacion());
        holder.textView_descripcion_vuelo.setText(listVuelos.get(position).getDetalle());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.listVuelos.size();
    }

}
