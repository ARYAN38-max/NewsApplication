package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{
    private EditText userName, userEmail, userPassword, userConformPassword;
    private String name, email, password, conformpassword;
    private Button registerBTN;
    private LinearLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);
        userName = findViewById(R.id.userRegisterName);
        userEmail = findViewById(R.id.userRegisterEmail);
        userPassword = findViewById(R.id.userRegisterPassword);
        userConformPassword = findViewById(R.id.conformPassword);


        registerBTN = findViewById(R.id.regisetBtn);

        name = userName.getText().toString();
        email = userEmail.getText().toString();
        password = userPassword.getText().toString();
        conformpassword = userConformPassword.getText().toString();

        registerBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if(name.equals("") || email.equals("") || password.equals("") || conformpassword.equals(""))
                {
                    showIncompleteSnackBar();
                }
            }
        });
    }

    private void showIncompleteSnackBar()
    {
        Snackbar.make(parent, "Please Fill All The Details", Snackbar.LENGTH_SHORT).show();
    }
}