package com.example.mybirdwatcher;

import android.widget.ImageView;

public class WatchListClass {

    public String birdWatchName, birdWatchLocation;
    int birdWatchImage;
    boolean checked;

    WatchListClass(int birdWatchImage, String birdWatchName,String birdWatchLocation, boolean checked) {
        this.birdWatchName = birdWatchName;
        this.birdWatchLocation = birdWatchLocation;
        this.birdWatchImage = birdWatchImage;
        this.checked = checked;


    }
}