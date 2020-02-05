package com.rosecreates.beertownfb;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ExpandedBeerAdapter extends RecyclerView.Adapter<Beer_Holder> {
       // private RecyclerViewClickListener mListener;
        ArrayList<Beer> beer;// = Collections.emptyList();
        Context context;

        public ExpandedBeerAdapter(ArrayList<Beer> beer, Context context)  {
            this.beer = new ArrayList<>();
            this.beer = beer;
            this.context = context;
               // mListener = listener;
                }

        @Override
        public Beer_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
                //Inflate the layout, initialize the View Holder
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_comment, parent, false);
                Beer_Holder holder = new Beer_Holder(v);

                return holder;

                }

        @Override
        public void onBindViewHolder(Beer_Holder holder, int position) {

                //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerVie

                holder.comment.setText(beer.get(position).commentList.get(0).toString());
                holder.timestamp.setText(beer.get(position).commentList.get(1).toString());
                holder.username.setText(beer.get(position).commentList.get(2).toString());


                //animate(holder);

            }

        @Override
        public int getItemCount() {

            return beer.size();
        }


        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
                super.onAttachedToRecyclerView(recyclerView);
        }



}


