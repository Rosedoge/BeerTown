package com.rosecreates.beertownfb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Beer_Holder extends RecyclerView.ViewHolder {

    CardView rv;
    TextView username;
    TextView timestamp;
    TextView comment;

    Beer_Holder(View itemView) {
        super(itemView);
        rv = (CardView) itemView.findViewById(R.id.cardView);
        username = (TextView) itemView.findViewById(R.id.username);
        comment = (TextView) itemView.findViewById(R.id.commentvalue);
        timestamp = (TextView) itemView.findViewById(R.id.timestamp);

    }
}