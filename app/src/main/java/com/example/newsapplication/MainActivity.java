package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
{
    private EditText userName, userEmail, userPassword, userConformPassword;

    private Button registerBTN, loginBTN;
    private LinearLayout parent;

    //FireBase Database
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        parent = findViewById(R.id.parent);
        userName = findViewById(R.id.userRegisterName);
        userEmail = findViewById(R.id.userRegisterEmail);
        userPassword = findViewById(R.id.userRegisterPassword);
        userConformPassword = findViewById(R.id.conformPassword);


        registerBTN = findViewById(R.id.regisetBtn);
        loginBTN = findViewById(R.id.loginBTNWindow);



        registerBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                String  conformPassword = userConformPassword.getText().toString();
                if(name.equals("") || email.equals("") || password.equals("") || conformPassword.equals(""))
                {
                   showIncompleteSnackBar();
                }
                else
                {
                    //Move To next Application

                    //Storing userCredentials in database
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference("Users");
                    userHelperClass userHelperClass = new userHelperClass(name, email, password, conformPassword);
                    //setting child class and main display of child class will be userName
                    databaseReference.child(name).setValue(userHelperClass);

                    NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notify=new Notification.Builder
                            (getApplicationContext()).setContentTitle("User Information").setContentText(name).
                            setContentTitle("subject").setSmallIcon(R.drawable.business).build();

                    notify.flags |= Notification.FLAG_AUTO_CANCEL;
                    notif.notify(0, notify);
                }
            }
        });
        loginBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "Redirecting You to Login Window", Toast.LENGTH_SHORT);
                Intent loginWindow = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginWindow);
            }
        });
    }

    private void showIncompleteSnackBar()
    {
        Snackbar.make(parent, "Please Fill All The Details", Snackbar.LENGTH_SHORT).show();
    }
}