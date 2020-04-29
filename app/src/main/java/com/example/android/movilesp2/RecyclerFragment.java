package com.example.android.movilesp2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment implements Handler.Callback, View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Callback listener;
    private Context context;
    private RecyclerView characterView;
    private Handler dataHandler;
    private ArrayList<Character> characters;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
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


        characterView = v.findViewById(R.id.charactersView);
        Button b = v.findViewById(R.id.changeButton);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.ejecutarAccion();
            }
        });

        dataHandler = new Handler(Looper.getMainLooper(),this);
        characters= new ArrayList<>();
        Request r = new Request("https://next.json-generator.com/api/json/get/NkaqQvGYd",dataHandler);
        r.start();
        return v;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;

        if(context instanceof Callback){
            listener = (Callback) context;
        } else{
            throw new RuntimeException("Activity is not a listener");
        }
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONObject objectData = (JSONObject) msg.obj;
        try {
            JSONArray data = objectData.getJSONArray("characters");
            for(int i=0; i<data.length();i++){
                JSONObject current = data.getJSONObject(i);
                int age = current.getInt("age");
                Character c = new Character(current.getString("name"),Integer.toString(age));
                characters.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CharacterAdapter adapter = new CharacterAdapter(characters,this);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        characterView.setLayoutManager(llm);
        characterView.setAdapter(adapter);

        return true;
    }

    @Override
    public void onClick(View v) {
        int pos = characterView.getChildLayoutPosition(v);
        Toast.makeText(this.getContext(),"Name: "+characters.get(pos).getName()+", age:"+characters.get(pos).getAge(), Toast.LENGTH_SHORT).show();
    }

    public interface Callback{
        void ejecutarAccion();
    }
}
