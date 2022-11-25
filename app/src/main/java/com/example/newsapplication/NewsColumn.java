package com.example.newsapplication;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsColumn extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_column, container, false);
        TextView newsTitle = (TextView) view.findViewById(R.id.newsTitle);
        TextView newsInformation = (TextView) view.findViewById(R.id.newsInformation);

        ImageView newsImage = (ImageView) view.findViewById(R.id.newsImage);

        return view;

    }
}