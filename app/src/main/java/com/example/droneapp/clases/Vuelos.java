package com.example.droneapp.clases;

public class Vuelos {
    private String nombre;
    private String fecha_de_creacion;
    private String detalle;

    public Vuelos(String nombre,String fecha,String detalle){
        this.detalle=detalle;
        this.nombre=nombre;
        this.fecha_de_creacion=fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(String fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
