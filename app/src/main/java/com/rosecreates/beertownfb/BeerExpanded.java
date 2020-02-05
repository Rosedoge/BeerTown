package com.rosecreates.beertownfb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class BeerExpanded extends AppCompatActivity {
    Beer curBeer;
    private DatabaseReference mDatabase;
    ArrayList<Beer> beers;
    // ...
    String TAG = "w";
    String searchTerm;
    ExpandedBeerAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_expanded);
        curBeer = getIntent().getParcelableExtra("beer");
        context = getApplicationContext();
        TextView tvName = (TextView) findViewById(R.id.name);
        TextView tvBrewer = (TextView) findViewById(R.id.brewer);
        TextView tvStyle = (TextView) findViewById(R.id.style);

        tvName.setText(curBeer.Name);// = curBeer.Name;
        tvBrewer.setText(curBeer.Brewer);
        tvStyle.setText(curBeer.Style);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comments);
        adapter = new ExpandedBeerAdapter(curBeer, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }
}
