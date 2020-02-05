package com.rosecreates.beertownfb;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Beer implements Parcelable {

    public String index;
    public String Name;
    public String Brewer;
    public String Style;
    public ArrayList commentList;
    public boolean expanded = false;
    public Beer() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Beer(String index, String name, String brewer,String style, ArrayList comments) {
        Log.d("meow", "beep");
        this.Name = name;
        this.Brewer = brewer;
        this.Style = style;
        this.commentList = comments;
    }
    public Beer(Parcel in){
        Name = in.readString();
        Brewer = in.readString();
        Style = in.readString();
        commentList = in.readArrayList(ArrayList.class.getClassLoader());
    }

    // This is to de-serialize the object
    public static final Parcelable.Creator<Beer> CREATOR = new Parcelable.Creator<Beer>() {
        public Beer createFromParcel(Parcel in) {
            return new Beer(in);
        }

        @Override
        public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Brewer);
        dest.writeString(Style);
        dest.writeList(commentList);
    }
}
