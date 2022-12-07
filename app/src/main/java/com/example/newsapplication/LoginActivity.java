package com.example.newsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout parent;
    private EditText userEmail, userPassword;
    private Button loginBTN;

    FirebaseDatabase db;
    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        loginBTN = findViewById(R.id.loginBTN);

        if (Build.VERSION.SDK_INT >= 21)
        {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }



        loginBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                if(email.equals("") || password.equals(""))
                {
                    showIncompleteSnackBar();
                    userEmail.setText("");
                    userPassword.setText("");
                }
                else
                {

                    Intent intent = new Intent(LoginActivity.this, ApplicationWindow.class);
                    startActivity(intent);
                }
            }
        });


    }


    private void showIncompleteSnackBar()
    {
        Snackbar.make(parent, "Please Fill all the information", Snackbar.LENGTH_SHORT).show();
    }
}