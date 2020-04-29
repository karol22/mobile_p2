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

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private Handler dataHandler;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataHandler = new Handler(Looper.getMainLooper(), this);
        btn = findViewById(R.id.button);
    }

    public void request(View v) {
        Request r = new Request("https://next.json-generator.com/api/json/get/NkaqQvGYd", dataHandler);
        r.run();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONArray datos = (JSONArray)msg.obj;
        Toast.makeText(this, "Retrieved data from URL "+datos.toString(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
