package com.example.acer.databaseacess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    Context context;
    ArrayList<StudentModal>models;
    public StudentAdapter(MainActivity mainActivity, ArrayList<StudentModal> studentModels) {
        this.context=mainActivity;
        this.models=studentModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        StudentModal modal=models.get(position);
        holder.rroll.setText(modal.getSt_rollno());
        holder.rname.setText(modal.getSt_name());
        holder.rphone.setText(modal.getSt_phone());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView rroll,rname,rphone;
        public MyViewHolder(View itemView) {
            super(itemView);
            rroll=itemView.findViewById(R.id.tv1);
            rname=itemView.findViewById(R.id.tv2);
            rphone=itemView.findViewById(R.id.tv3);
        }
    }
}
