package com.example.myquizapp.Football_part;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myquizapp.Dashboard;
import com.example.myquizapp.R;
import com.example.myquizapp.Technology.Technologies_qsn;

public class ResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);




        if(fquiz.correct>0 && fquiz.wrong>0 && fquiz.correct>0) {
            StringBuffer sb = new StringBuffer();
            sb.append("Correct answers: " + fquiz.correct + "\n");
            StringBuffer sb2 = new StringBuffer();
            sb2.append("Wrong Answers: " + fquiz.wrong + "\n");
            StringBuffer sb3 = new StringBuffer();
            sb3.append("Final Score: " + fquiz.correct + "\n");

            tv.setText(sb);
            tv2.setText(sb2);
            tv3.setText(sb3);
            fquiz.correct=0;
            fquiz.wrong=0;

        }else if(Technologies_qsn.t_correct>0 &&Technologies_qsn.t_wrong>0&&Technologies_qsn.t_correct>0) {
            StringBuffer sb4 = new StringBuffer();
            sb4.append("Correct answers: " + Technologies_qsn.t_correct + "\n");
            StringBuffer sb5 = new StringBuffer();
            sb5.append("Wrong Answers: " + Technologies_qsn.t_wrong + "\n");
            StringBuffer sb6 = new StringBuffer();
            sb6.append("Final Score: " + Technologies_qsn.t_correct + "\n");
            tv.setText(sb4);
            tv2.setText(sb5);
            tv3.setText(sb6);
            Technologies_qsn.t_correct=0;
            Technologies_qsn.t_wrong=0;
        }

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(in);
            }
        });
    }
}
