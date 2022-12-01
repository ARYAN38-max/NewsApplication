package com.example.newsapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class BusinessFragment extends Fragment
{
    View view;

    FirebaseDatabase db;
    DatabaseReference dbr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_business, container, false);



        TextView newsHeading = (TextView) view.findViewById(R.id.BusinessNewsHeading);
        TextView newsContent = (TextView) view.findViewById(R.id.BusinessNewsContent);

        db= FirebaseDatabase.getInstance();
        dbr = db.getReference("HomePageNews").child("Business");

        dbr.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String content = snapshot.getValue(String.class);
                newsContent.setText(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });

        newsHeading.setText("Singapore Airlines and Tata Sons to merge Air India, Vistara");

        return view;

    }
}