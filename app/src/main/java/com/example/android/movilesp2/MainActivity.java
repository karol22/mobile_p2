package com.example.android.movilesp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerFragment.Callback, Handler.Callback {

    private Handler dataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataHandler = new Handler(Looper.getMainLooper(), this);

        RecyclerFragment fragmentito = new RecyclerFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentito, "fragmento");
        transaction.commit();
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

    @Override
    public void ejecutarAccion() {
        //SwapFragments
        Log.wtf("Fragment msg", "time to swap");
    }


}
