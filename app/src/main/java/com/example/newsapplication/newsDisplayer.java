package com.example.newsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class newsDisplayer extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_displayer, container, false);

        TextView homepageTitle = (TextView) view.findViewById(R.id.homePagenewsTitle);
        ImageView homePageImage = (ImageView) view.findViewById(R.id.homePagenewsImage);
        TextView homepageContent = (TextView) view.findViewById(R.id.homePageNewsContent);

        homepageTitle.setText("Hello, This is first News of this app");
        homepageContent.setText("This app is build using java in android studio");

        return view;

    }
}