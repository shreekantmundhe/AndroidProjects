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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Fragment that displays "Tuesday".
 */
public class TravelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        ImageView localImage = (ImageView) view.findViewById(R.id.local_image);
        localImage.setImageResource(R.drawable.local);

        ImageView pmpmlImage = (ImageView) view.findViewById(R.id.pmpml_image);
        pmpmlImage.setImageResource(R.drawable.pmpml);

        ImageView autoImage = (ImageView) view.findViewById(R.id.auto_image);
        autoImage.setImageResource(R.drawable.auto);

        return view;
    }
}
