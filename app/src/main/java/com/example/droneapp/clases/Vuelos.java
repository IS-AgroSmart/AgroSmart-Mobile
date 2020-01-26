package com.example.droneapp.clases;

import java.io.Serializable;

public class Vuelos implements Serializable{
    private String nombre;
    private String fecha_de_creacion;
    private String detalle;
    private String tiempo_de_procesamiento;
    private String notas;

    public Vuelos(String nombre,String fecha,String detalle)
    {
        this.detalle=detalle;
        this.nombre=nombre;
        this.fecha_de_creacion=fecha;
        this.tiempo_de_procesamiento="16h 40m";
        this.notas="Vuelo procesado sin problemas";
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

    public String getTiempo_de_procesamiento() {
        return tiempo_de_procesamiento;
    }

    public void setTiempo_de_procesamiento(String tiempo_de_procesamiento) {
        this.tiempo_de_procesamiento = tiempo_de_procesamiento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
