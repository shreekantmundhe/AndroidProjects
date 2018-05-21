package com.example.android.quakereport;

/**
 * Created by prash on 03-02-2018.
 */

public class Collection {


    //declare string for date
    private long mDate;

    //declare string for location
    private String mLocation;

    //declare string for affect
    private double mAffect;

    //declare string for url
    private String murl;



    public Collection(double Affect, String Location, long Date, String url){
        mDate =  Date;
        mLocation = Location ;
        mAffect = Affect;
        murl = url;

    }


    public long getmDate(){
        return mDate;
    }


    public String getmLocation(){
        return  mLocation;
    }


    public double getmAffect(){
        return mAffect;
    }

    public String getMurl(){
        return murl;
    }


}
