package com.example.myquizapp.Login_part;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myquizapp.Dashboard;
import com.example.myquizapp.R;

public class Login_page extends AppCompatActivity {
    TextView registerText;
    MyDatabaseHelper databaseHelper;

    private Button loginbtn;
    private EditText signinemail,signinpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Toolbar toolbar = findViewById(R.id.title_toolbar_id);
        registerText = findViewById(R.id.register_text);

        loginbtn=findViewById(R.id.signin_btn_id);

        signinemail=findViewById(R.id.signIn_Email_Id);
        signinpassword=findViewById(R.id.sign_In_password_id);



        databaseHelper=new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();




        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email = signinemail.getText().toString();
                String password = signinpassword.getText().toString();

                Boolean result = databaseHelper.findPassword(email,password);
                if (result==true)
                {
                   Intent intent = new Intent(Login_page.this, Dashboard.class);
                    Toast.makeText(getApplicationContext(),"You are successfully Login Sir",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"email and password doesn't match",Toast.LENGTH_SHORT).show();
                }
            }

        });


       setSupportActionBar(toolbar);

       getSupportActionBar().setTitle("Sign in");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayShowHomeEnabled(true);


    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Login_page.this.finish();
        }
        return super.onOptionsItemSelected(item);





    }
}
