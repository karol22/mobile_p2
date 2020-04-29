package com.example.android.movilesp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerFragment.Callback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerFragment fragmentito = new RecyclerFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentito, "fragmento");
        transaction.commit();
    }

    @Override
    public void ejecutarAccion() {
        //SwapFragments
        Log.wtf("Fragment msg", "time to swap");
    }


}
