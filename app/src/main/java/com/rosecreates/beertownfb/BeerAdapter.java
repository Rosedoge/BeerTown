package com.rosecreates.beertownfb;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosecreates.beertownfb.Beer;
import com.rosecreates.beertownfb.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerViewHolder>{
    private ArrayList<Beer> list = new ArrayList<>();
    private Context mContext;
   // private List<Beer> list;

    public BeerAdapter(Context context, ArrayList<Beer> beers) {
        mContext = context;
        list = beers;
    }

    @Override
    public BeerAdapter.BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beer, parent, false);
        BeerViewHolder viewHolder = new BeerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BeerAdapter.BeerViewHolder holder, int position) {
        holder.bindBeer(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class BeerViewHolder extends RecyclerView.ViewHolder {
       // @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;

        @BindView(R.id.title) TextView mNameTextView;
        @BindView(R.id.description) TextView mCategoryTextView;
        //@BindView(R.id.sub_item_year) TextView mRatingTextView;
        private Context mContext;

        public BeerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindBeer(Beer beer) {
            if(beer != null) {
                mNameTextView.setText(beer.Name);
                mCategoryTextView.setText(beer.Style);
              //  mRatingTextView.setText("Rating: " + beer.Brewer + "/5");
            }
        }
    }
}