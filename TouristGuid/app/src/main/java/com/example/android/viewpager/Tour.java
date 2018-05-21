package com.example.android.viewpager;

import java.io.Serializable;

/**
 * Created by shrikantm on 03/05/2018.
 */

public class Tour implements Serializable {
    private String tourName;
    private String tourDescription;
    private int tourImage;
    private int tourSound;

    public Tour(String name, String description, int image) {
        tourName = name;
        tourDescription = description;
        tourImage = image;
    }

    public Tour(String name, int image, int sound) {
        tourName = name;
        tourImage = image;
        tourSound = sound;
    }

    public Tour(String name, int image) {
        tourName = name;
        tourImage = image;
    }

    public Tour(String name) {
        tourName = name;
    }

    public String getTourName() {
        return tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public int getTourImage() {
        return tourImage;
    }

    public int getTourSound() {
        return tourSound;
    }


    public boolean hasTourImage() {
        if (tourImage != 0) {
            return  true;
        }
        else {
            return false;
        }
    }

    public boolean hasTourDescription() {
        if (tourDescription != null) {
            return  true;
        }
        else {
            return false;
        }
    }
}

