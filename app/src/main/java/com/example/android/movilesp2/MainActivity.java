package com.example.android.movilesp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private Handler dataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataHandler = new Handler(Looper.getMainLooper(), this);
    }

    public void request(View v) {
        Request r = new Request("https://next.json-generator.com/api/json/get/NkaqQvGYd", dataHandler);
        r.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONObject datos = (JSONObject) msg.obj;
        Toast.makeText(this, "Retrieved data from URL "+datos.toString(), Toast.LENGTH_SHORT).show();
        JSONArray elements = null;
        try {
            elements = datos.getJSONArray("characters");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Toast.makeText(this, "Retrieved data from URL "+elements.get(0).toString(), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
