/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Fragment that displays "Wednesday".
 */
public class AttractionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);
        ImageView movieImage = (ImageView) view.findViewById(R.id.movie_image);
        movieImage.setImageResource(R.drawable.movie);
        movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movie = new Intent(getContext(), MovieActivity.class);
                startActivity(movie);
            }
        });

        ImageView picnicImage = (ImageView) view.findViewById(R.id.picnin_image);
        picnicImage.setImageResource(R.drawable.picnic);
        picnicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent picnic = new Intent(getContext(), PicnicActivity.class);
                startActivity(picnic);
            }
        });

        ImageView festivalImage = (ImageView) view.findViewById(R.id.festival_image);
        festivalImage.setImageResource(R.drawable.festival);
        festivalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent festival = new Intent(getContext(), FestivalActivity.class);
                startActivity(festival);
            }
        });

        ImageView foodImage = (ImageView) view.findViewById(R.id.food_image);
        foodImage.setImageResource(R.drawable.food);
        foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent food = new Intent(getContext(), FoodActivity.class);
                startActivity(food);
            }
        });

        ImageView natakImage = (ImageView) view.findViewById(R.id.natak_image);
        natakImage.setImageResource(R.drawable.natak);
        natakImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent natak = new Intent(getContext(), NatakActivity.class);
                startActivity(natak);
            }
        });

        ImageView puneriImage = (ImageView) view.findViewById(R.id.puneri_image);
        puneriImage.setImageResource(R.drawable.puneri);
        puneriImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent puneri = new Intent(getContext(), PuneriActivity.class);
                startActivity(puneri);
            }
        });

        return view;
    }
}
