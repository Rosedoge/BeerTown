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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

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
        beers = new ArrayList<>();
        FirebaseApp.initializeApp(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        basicQueryValueListener();



        TextView tvName = (TextView) findViewById(R.id.name);
        TextView tvBrewer = (TextView) findViewById(R.id.brewer);
        TextView tvStyle = (TextView) findViewById(R.id.style);

        tvName.setText(curBeer.Name);// = curBeer.Name;
        tvBrewer.setText(curBeer.Brewer);
        tvStyle.setText(curBeer.Style);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comments);
        adapter = new ExpandedBeerAdapter(beers, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // adapter.notifyDataSetChanged();
    }


    public void basicQueryValueListener() {
        // String myUserId = getUid();
        Query myTopPostsQuery = mDatabase.child("Beers")//.child('Beers')
                .orderByChild("Name");

        // [START basic_query_value_listener]
        // My top posts by number of stars
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {


                    for (DataSnapshot snappy: postSnapshot.child("Comments").getChildren()) {
                        Beer newPost = postSnapshot.getValue(Beer.class);
                        Comment comment = snappy.getValue(Comment.class);
                        ArrayList<String> aListNumbers = new ArrayList<String>(Arrays.asList(comment.Username,comment.Value, Integer.toString(comment.Timestamp)));
                        newPost.commentList = aListNumbers;
                        if(newPost!= null) {
                            beers.add(newPost);
                            adapter.notifyDataSetChanged();
                        }
                    }



                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        // [END basic_query_value_listener]
    }
}
