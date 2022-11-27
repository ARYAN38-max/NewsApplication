package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

public class ApplicationWindow extends AppCompatActivity
{
    FrameLayout homepagenewsContainer;
    CardView techWindow, automobileWindow, businessWindow, stockWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_window);


        replaceFragment(new newsDisplayer());


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));

        homepagenewsContainer = findViewById(R.id.homePageNewsContainer);

        techWindow = findViewById(R.id.techWindow);
        automobileWindow = findViewById(R.id.autoMobileWindow);
        businessWindow = findViewById(R.id.businessWindow);
        stockWindow = findViewById(R.id.StockWindow);

        techWindow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });


        /** private void replaceFragment(Fragment newsDisplaye)
         {
         FragmentManager fragmentManager = getSupportFragmentManager();
         FragmentTransaction transaction = fragmentManager.beginTransaction();
         transaction.replace(R.id.homePageNewsContainer, NewsColumn);
         transaction.commit();
         }
         **/


    }


}

    private void replaceFragment(newsDisplayer newsDisplayer) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.homePageNewsContainer,newsDisplayer);
        transaction.commit();
    }
}