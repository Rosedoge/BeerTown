package com.rosecreates.beertownfb;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class View_Holder extends RecyclerView.ViewHolder {

    CardView rv;
    TextView title;
    TextView description;
    ImageView imageView;

    View_Holder(View itemView) {
        super(itemView);
        rv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);

    }
}