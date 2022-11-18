package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout parent;
    private EditText userEmail, userPassword;
    private Button loginBTN;
    private String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        loginBTN = findViewById(R.id.loginBTN);

        email = userEmail.getText().toString();
        password = userPassword.getText().toString();

        loginBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(email.equals("") || password.equals(""))
                {
                    showIncompleteSnackBar();
                }
                else
                {
                    //Move To Application  Window
                }
            }
        });


    }

    private void showIncompleteSnackBar()
    {
        Snackbar.make(parent, "Please Fill all the information", Snackbar.LENGTH_SHORT).show();
    }
}