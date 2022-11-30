package com.example.newsapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class newsDisplayer extends Fragment {
    View view;
    FirebaseDatabase homePagedb;
    DatabaseReference homepagevalue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_displayer, container, false);

        homePagedb = FirebaseDatabase.getInstance("https://newsapplication-936a9-default-rtdb.firebaseio.com/");
        homepagevalue = homePagedb.getReference("HomePageNews").child("Tech");

        TextView homepageTitle = (TextView) view.findViewById(R.id.homePagenewsTitle);
        ImageView homePageImage = (ImageView) view.findViewById(R.id.homePagenewsImage);
        TextView homepageContent = (TextView) view.findViewById(R.id.homePageNewsContent);

        homepagevalue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String techNews = snapshot.getValue(String.class);
                homepageContent.setText(techNews);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        homepageTitle.setText("Use of drone to transport organs between cities deemed a success\n" +
                "by Raquel Torres\n" +
                "November 22, 2022\n" );


        return view;

    }
}