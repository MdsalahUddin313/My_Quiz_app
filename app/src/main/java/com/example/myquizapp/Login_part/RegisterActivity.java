package com.example.myquizapp.Login_part;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myquizapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText fullname,mobile,email,streeatadd,password,conpassword;
    private Button registerBtn;
    UserDetails userDetails;
    MyDatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname=findViewById(R.id.fullNameId);
        mobile=findViewById(R.id.mobileId);
        email=findViewById(R.id.emailId);
        streeatadd=findViewById(R.id.streetId);
        password=findViewById(R.id.passwordId);
        conpassword=findViewById(R.id.confirmPassId);
        registerBtn=findViewById(R.id.register_Pager_signUp_Btn);registerBtn.setOnClickListener(this);

        databaseHelper=new MyDatabaseHelper(this);

        userDetails = new UserDetails();



        Toolbar toolbar = findViewById(R.id.title_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = fullname.getText().toString();
                String mobile_num= mobile.getText().toString();
                String memail= email.getText().toString();
                String mAddress= streeatadd.getText().toString();
                String mpassword= password.getText().toString();
                String mconpass= conpassword.getText().toString();


                userDetails.setName(fullName);
                userDetails.setMobile(mobile_num);
                userDetails.setEmail(memail);
                userDetails.setAddress(mAddress);
                userDetails.setPassword(mpassword);
                userDetails.setConformPassword(mconpass);



                long rowId =  databaseHelper.insertData(userDetails);

                if (rowId>0)
                {
                    Toast.makeText(getApplicationContext(),rowId+" You Are successful Registered",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Row inserted  failed",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_Pager_signUp_Btn:
                RegisterActivity.this.finish();
                Intent i=new Intent(RegisterActivity.this,Login_page.class);startActivity(i);
                break;
        }


    }
}
