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
package com.example.android.news;

public class News {

    public final String newsTitle;

    public final String url;

    public final String date;

    public final String author;

    public final String section;


    public News(String newsTitle, String date, String url, String author, String section) {
        this.url = url;
        this.newsTitle = newsTitle;
        this.date = date;
        this.author = author;
        this.section = section;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getDate() {
        return  date;

    }

    public String getAuthor() {
        return author;

    }

    public String getUrl() {
        return url;
    }

    public String getSection() {
        return section;
    }

}
