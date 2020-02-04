package com.rosecreates.beertownfb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BeerExpanded extends AppCompatActivity {
    Beer curBeer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_expanded);
        curBeer = getIntent().getParcelableExtra("beer");

        TextView tvName = (TextView) findViewById(R.id.name);
        TextView tvBrewer = (TextView) findViewById(R.id.brewer);
        TextView tvStyle = (TextView) findViewById(R.id.style);

        tvName.setText(curBeer.Name);// = curBeer.Name;
        tvBrewer.setText(curBeer.Brewer);
        tvStyle.setText(curBeer.Style);
    }
}
