package com.example.android.movilesp2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImagesFragment extends Fragment  implements Handler.Callback,View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private RecyclerFragment.Callback listener;
    private Context context;
    private RecyclerView imageView;
    private Handler dataHandler;


    public ImagesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImagesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImagesFragment newInstance(String param1, String param2) {
        ImagesFragment fragment = new ImagesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);


        imageView = v.findViewById(R.id.imageView);
        Button b = v.findViewById(R.id.imageButton);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), "ataca, Ramona!", Toast.LENGTH_SHORT).show();
                listener.ejecutarAccion();
            }
        });
        
        return v;
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        return false;
    }

    @Override
    public void onClick(View view) {
        return;
    }
    public interface Callback{
        void ejecutarAccion();
    }
}
