package com.rosecreates.beertownfb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BeerSearch extends AppCompatActivity {
    private DatabaseReference mDatabase;
    ArrayList<Beer> beers;
// ...
    String TAG = "w";
    String searchTerm;
    TestAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_search);
        Intent intent = getIntent();
        searchTerm = intent.getStringExtra("name");
        beers =  new ArrayList<Beer>();
        FirebaseApp.initializeApp(this);
        context = getApplicationContext();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        final ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
              //  Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());
                //Beer newPost = dataSnapshot.child("one").getValue(Beer.class);
                //System.out.println("Author: " + newPost.Name);
                //System.out.println("Title: " + newPost.Brewer);

                // A new comment has been added, add it to the displayed list
                //Comment comment = dataSnapshot.getValue(Comment.class);

                // ...
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
               // Comment newComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                //Comment movedComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
            }
        };

        basicQuery();
        basicQueryValueListener();

        // My top posts by number of stars
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recView);
        adapter = new TestAdapter( beers, context,   new RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Log.d(TAG, "clicked position:" + position);
                ExpandBeer(beers.get(position));
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void ExpandBeer(Beer beer){
        Intent intent = new Intent(BeerSearch.this, BeerExpanded.class);
        //EditText editText = (EditText) findViewById(R.id.eText);
        //String message = editText.getText().toString();
        intent.putExtra("beer", beer);
        BeerSearch.this.startActivity(intent);
    }
    public void basicQuery() {
        // [START basic_query]
        // My top posts by number of stars
       // String myUserId = getUid();

        DatabaseReference o = mDatabase.getDatabase().getReference("Beers");

        Query myTopPostsQuery = o.child("Beers").orderByChild("Name");

        myTopPostsQuery.addChildEventListener(new ChildEventListener() {
            // TODO: implement the ChildEventListener methods as documented above
            // [START_EXCLUDE]
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
            public void onChildRemoved(DataSnapshot dataSnapshot) { }
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
            public void onCancelled(DatabaseError databaseError) { }
            // [END_EXCLUDE]
        });
        // [END basic_query]
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

                    Beer newPost = postSnapshot.getValue(Beer.class);
                    System.out.println("Author: " + newPost.Name);
                    System.out.println("Title: " + newPost.Brewer);
                    if(newPost.Name.toUpperCase().contains(searchTerm.toUpperCase())){
                        beers.add(newPost);
                        adapter.notifyDataSetChanged();
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