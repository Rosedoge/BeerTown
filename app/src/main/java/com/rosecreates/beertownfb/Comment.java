package com.rosecreates.beertownfb;

import java.sql.Time;

public class Comment {

    public String Username;
    public int Timestamp;
    public String Value;

    public Comment() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Comment(String user, int time, String val){
        Username = user;
        Timestamp = time;
        Value = val;
    }
}
