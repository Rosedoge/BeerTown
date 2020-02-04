package com.rosecreates.beertownfb;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<View_Holder> {

        List<Beer> list = Collections.emptyList();
        Context context;

public TestAdapter(List<Beer> list, Context context) {
        this.list = list;
        this.context = context;
        }

@Override
public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beer, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

        }

@Override
public void onBindViewHolder(View_Holder holder, int position) {
        if(list.get(position) == null){
                return;
        }
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).Name);
        holder.description.setText(list.get(position).Brewer);
       // holder.imageView.setImageResource(list.get(position).imageId);

        //animate(holder);

        }

@Override
public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
        }

@Override
public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        }

// Insert a new item to the RecyclerView on a predefined position
public void insert(int position, Beer data) {
        list.add(position, data);
        notifyItemInserted(position);
        }

// Remove a RecyclerView item containing a specified Data object
public void remove(Beer data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
        }

}


