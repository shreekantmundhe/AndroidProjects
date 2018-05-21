package com.example.android.sairat;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shrikantm on 02/05/2018.
 */

public class MusicAdapter extends ArrayAdapter<Music> {

    public MusicAdapter(Activity context, ArrayList<Music> music) {
        super(context, 0, music);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        Music music = getItem(position);

        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.songName);
        songNameTextView.setText(music.getSongName());

        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.songArtist);
        if(music.hasArtisName()) {
            artistNameTextView.setText(music.getArtistName());
        }
        else {
            artistNameTextView.setVisibility(View.GONE);
        }

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.number_image);
        if(music.hasMusicImage()) {
            iconView.setImageResource(music.getSongImage());
        }
        else {
            iconView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}

