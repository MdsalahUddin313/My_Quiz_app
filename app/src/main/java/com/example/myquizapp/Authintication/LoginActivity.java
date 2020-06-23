package com.example.myquizapp.Authintication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myquizapp.R;

public class LoginActivity extends AppCompatActivity {

    TextView Sign_up;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Sign_up=findViewById(R.id.sign_up_id);
        loginbutton=findViewById(R.id.login_button_id);
        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(LoginActivity.this,Register_activity.class);
                startActivity(i2);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(LoginActivity.this,Admin_profile.class);
                startActivity(i2);
            }
        });

    }
}
