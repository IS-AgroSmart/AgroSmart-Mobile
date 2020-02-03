package com.example.droneapp.ui.login;

import android.os.AsyncTask;
import android.util.Log;

import com.example.droneapp.APIClient.FlightHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginTask extends AsyncTask<String, Void, String> {
    public LoginTaskResponse delegate = null;
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public LoginTask(LoginTaskResponse delegate) {
        this.delegate = delegate;
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    protected String doInBackground(String... data) {
        String username = data[0];
        String password = data[1];

        try {
            String json = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
            String response = post(FlightHelper.BASE_URL + "api-auth", json);
            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();
            delegate.processFinish(jobject.get("token").getAsString());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
