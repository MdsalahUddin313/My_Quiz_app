package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myquizapp.Football_part.Football;

public class Dashboard extends AppCompatActivity implements  View.OnClickListener{

    Button btn;
    ImageView sports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
       // btn = (Button) findViewById(R.id.football_id);
        sports=(ImageView)findViewById(R.id.sports_id); sports.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sports_id:
                Intent i = new Intent(Dashboard.this, Football.class);
                startActivity(i);
                break;
        }
    }
}
