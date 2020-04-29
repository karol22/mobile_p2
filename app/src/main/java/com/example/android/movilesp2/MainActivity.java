package com.example.android.movilesp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements RecyclerFragment.Callback, ImagesFragment.Callback{
    RecyclerFragment fragmentito;
    ImagesFragment fragmentito2;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentito = new RecyclerFragment();
        fragmentito2 = new ImagesFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentito, "fragmento");
        transaction.commit();
    }

    @Override
    public void ejecutarAccion() {
        //SwapFragments
        Log.wtf("Fragment msg", "time to swap");
        manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentByTag("fragmento");

        if (f!= null){
            ImagesFragment img = new ImagesFragment();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(f);
            transaction.add(R.id.container,img,"fragmento");
            transaction.commit();
        }

    }

    @Override
    public void cambio2() {
        manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentByTag("fragmento");

        if (f!= null){
            RecyclerFragment r = new RecyclerFragment();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(f);
            transaction.add(R.id.container,r,"fragmento");
            transaction.commit();
        }
    }


}
