package com.rosecreates.beertownfb;

import android.util.Log;

import java.util.List;

public class IndexBeer {
    public Beer beer;

    public IndexBeer() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }


    public IndexBeer(Beer beer) {
        Log.d("wow", "fucking meow dude");
        this.beer = beer;
    }
}
