package com.example.android.sairat;

import java.io.Serializable;

/**
 * Created by shrikantm on 02/05/2018.
 */

public class Music implements Serializable {
    private String sSongName;
    private String sArtistName;
    private int sSongImage;

    public Music(String songName, String artistName, int songImage) {
        sSongName = songName;
        sArtistName = artistName;
        sSongImage = songImage;
    }

    public Music(String songName, int songImage) {
        sSongName = songName;
        sSongImage = songImage;
    }

    public Music(String songName) {
        sSongName = songName;
    }

    public String getSongName() {
        return sSongName;
    }

    public String getArtistName() {
        return sArtistName;
    }

    public int getSongImage() {
        return sSongImage;
    }

    public boolean hasArtisName() {
        if (sArtistName != null) {
            return  true;
        }
        else {
            return false;
        }
    }

    public boolean hasMusicImage() {
        if (sSongImage != 0) {
            return  true;
        }
        else {
            return false;
        }
    }
}
