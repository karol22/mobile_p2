package com.example.android.movilesp2;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request extends Thread {

    private String url;
    private Handler handler;

    public Request(String url, Handler handler) {
        this.url = url;
        this.handler = handler;
    }

    public void run() {
        try {
            URL path = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) path.openConnection();

            int answer = connection.getResponseCode();

            if(answer == HttpURLConnection.HTTP_OK) {

                InputStream file = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(file));

                StringBuilder builder = new StringBuilder();
                String lineaActual;

                while((lineaActual = br.readLine()) != null){
                    builder.append(lineaActual);
                }
                String json = builder.toString();

                Log.wtf("JSON", json);

                JSONArray scottFriends = new JSONArray(json);

                Message message = new Message();
                message.obj = scottFriends;
                handler.sendMessage(message);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}