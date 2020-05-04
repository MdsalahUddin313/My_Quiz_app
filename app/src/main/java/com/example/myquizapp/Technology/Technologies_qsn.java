package com.example.myquizapp.Technology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myquizapp.Football_part.ResultActivity;
import com.example.myquizapp.R;

public class Technologies_qsn extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?",

            "11Which method can be defined only once in a program?",
            "12Which of these is not a bitwise operator?",
            "13Which keyword is used by method to refer to the object that invoked it?",
            "14Which of these keywords is used to define interfaces in Java?",
            "15Which of these access specifiers can be used for an interface?",
            "16Which of the following is correct way of importing an entire package ‘pkg’?",
            "17What is the return type of Constructors?",
            "18Which of the following package stores all the standard java classes?",
            "19Which of these method of class String is used to compare two String objects for their equality?",
            "20An expression involving byte, int, & literal numbers is promoted to which of these?"
    };
    String answers[] = {"main method", "<=", "this", "interface", "public", "import pkg.*", "None of the mentioned", "java", "equals()", "int",
            "main method", "<=", "this", "interface", "public", "import pkg.*", "None of the mentioned", "java", "equals()", "int"};
    String opt[] = {
            "finalize method", "main method", "static method", "private method",
            "&", "&=", "|=", "<=",
            "import", "this", "catch", "abstract",
            "Interface", "interface", "intf", "Intf",
            "public", "protected", "private", "All of the mentioned",
            "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
            "int", "float", "void", "None of the mentioned",
            "lang", "java", "util", "java.packages",
            "equals()", "Equals()", "isequal()", "Isequal()",
            "int", "long", "byte", "float",

            "finalize method", "main method", "static method", "private method",
            "&", "&=", "|=", "<=",
            "import", "this", "catch", "abstract",
            "Interface", "interface", "intf", "Intf",
            "public", "protected", "private", "All of the mentioned",
            "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
            "int", "float", "void", "None of the mentioned",
            "lang", "java", "util", "java.packages",
            "equals()", "Equals()", "isequal()", "Isequal()",
            "int", "long", "byte", "float"
    };
    int flag ;
    public static int t_marks = 0, t_correct = 0, t_wrong = 0,last_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technologies_qsn);


        final TextView score = (TextView) findViewById(R.id.t_text_score);


        /*
          TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

         */
        Intent intent = getIntent();
        String name = intent.getStringExtra("catagory");
        if(name=="B"){
             flag=10;
            last_position=19;
        }else if(name=="C"){
            flag=20;
            last_position=29;
        }

        submitbutton = (Button) findViewById(R.id.t_nextQSn_id);
        quitbutton = (Button) findViewById(R.id.t_quitbtn_id);
        tv = (TextView) findViewById(R.id.Tqsn);

        radio_g = (RadioGroup) findViewById(R.id.t_answersgrp);
        rb1 = (RadioButton) findViewById(R.id.t_radioButton);
        rb2 = (RadioButton) findViewById(R.id.t_radioButton2);
        rb3 = (RadioButton) findViewById(R.id.t_radioButton3);
        rb4 = (RadioButton) findViewById(R.id.t_radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[flag * 4]);
        rb2.setText(opt[flag * 4 + 1]);
        rb3.setText(opt[flag * 4 + 2]);
        rb4.setText(opt[flag * 4 + 3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    t_correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    t_wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + t_correct);

                if (flag < questions.length||flag==last_position) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    t_marks = t_correct;
                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}

