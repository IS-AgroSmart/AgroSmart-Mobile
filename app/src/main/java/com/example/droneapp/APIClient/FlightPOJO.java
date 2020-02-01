package com.example.droneapp.APIClient;

import org.json.JSONObject;

import java.io.Serializable;

public class FlightPOJO implements Serializable {

    protected String uuid;
    protected String name;
    protected int user;
    protected String date;
    protected String camera;
    protected String state;
    protected JSONObject node_odm_info;
    protected double processing_time;
    protected String annotations;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public JSONObject getNode_odm_info() {
        return node_odm_info;
    }

    public void setNode_odm_info(JSONObject node_odm_info) {
        this.node_odm_info = node_odm_info;
    }

    public double getProcessing_time() {
        return processing_time;
    }

    public void setProcessing_time(double processing_time) {
        this.processing_time = processing_time;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "FlightPOJO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", date='" + date + '\'' +
                ", camera='" + camera + '\'' +
                ", state='" + state + '\'' +
                ", node_odm_info=" + node_odm_info +
                ", processing_time=" + processing_time +
                '}';
    }
}
