package com.example.android.movilesp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
<<<<<<< HEAD
=======
import android.widget.Toast;
>>>>>>> brian

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>{
    public static class CharacterViewHolder extends RecyclerView.ViewHolder{
        public TextView name,age;

        public CharacterViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.nameLabel);
            age = itemView.findViewById(R.id.ageLabel);
        }

    }

    private ArrayList<Character> characters;
    private View.OnClickListener listener;

    public CharacterAdapter(ArrayList<Character> characters, View.OnClickListener listener){
        this.characters = characters;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Button b = v.findViewById(R.id.showInfo);
        b.setOnClickListener(listener);

        CharacterViewHolder cvh = new CharacterViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position){
        holder.name.setText(characters.get(position).getName());
        holder.age.setText(characters.get(position).getAge());
    }

    @Override
    public int getItemCount(){return characters.size();}
}
