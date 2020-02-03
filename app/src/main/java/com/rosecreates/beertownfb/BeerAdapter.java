package com.rosecreates.beertownfb;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosecreates.beertownfb.Beer;
import com.rosecreates.beertownfb.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.RecViewHolder> {

    private List<Beer> list;

    public BeerAdapter(List<Beer> list) {
        this.list = list;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_beer, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {
        Beer beer = list.get(position);

        holder.bind(beer);

        holder.itemView.setOnClickListener(v -> {
            boolean expanded = beer.expanded;
            beer.expanded = !beer.expanded;
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView genre;
        private TextView year;
        private View subItem;

        public RecViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title);
            genre = itemView.findViewById(R.id.sub_item_genre);
            year = itemView.findViewById(R.id.sub_item_year);
            subItem = itemView.findViewById(R.id.sub_item);
        }

        private void bind(Beer beer) {
            boolean expanded = beer.expanded;

            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

            title.setText(beer.Name);
            genre.setText("Genre: " +beer.Style);
            year.setText("Brewer " + beer.Brewer);
        }
    }
}