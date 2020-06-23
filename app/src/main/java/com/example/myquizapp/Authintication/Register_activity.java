package com.example.myquizapp.Authintication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myquizapp.R;

public class Register_activity extends AppCompatActivity {
Button submit;
TextView login_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        submit =(Button)findViewById(R.id.submit_button_id) ;
        login_text=(TextView)findViewById(R.id.login_id);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Register_activity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(Register_activity.this,LoginActivity.class);
                startActivity(i2);
            }
        });


    }
}
