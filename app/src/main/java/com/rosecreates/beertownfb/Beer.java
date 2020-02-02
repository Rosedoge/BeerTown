package com.rosecreates.beertownfb;

import java.util.List;

public class Beer {

    public String name;
    public String brewer;
    public List<Comment> commentList;

    public Beer() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Beer(String name, String brewer, List<Comment> comments) {
        this.name = name;
        this.brewer = brewer;
        this.commentList = comments;
    }

}
