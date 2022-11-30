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


public class StockNews extends Fragment
{
    View view;

    FirebaseDatabase db;
    DatabaseReference dbr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment



         view = inflater.inflate(R.layout.fragment_stock_news, container, false);
         TextView title  = (TextView) view.findViewById(R.id.StockNewsTitle);
         TextView stockContent = (TextView) view.findViewById(R.id.StockNewsContent);

        db = FirebaseDatabase.getInstance();
        dbr = db.getReference("HomePageNews").child("Stock");
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String content = snapshot.getValue(String.class);
                stockContent.setText(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });

         return view;
    }
}