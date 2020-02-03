package com.rosecreates.beertownfb;

import android.util.Log;

import java.util.List;

public class Beer {

    public String index;
    public String Name;
    public String Brewer;
    public String Style;
    public List<Comment> commentList;

    public Beer() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Beer(String index, String name, String brewer,String style, List<Comment> comments) {
        Log.d("meow", "beep");
        this.Name = name;
        this.Brewer = brewer;
        this.Style = style;
        this.commentList = comments;
    }

}
