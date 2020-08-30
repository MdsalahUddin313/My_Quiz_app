package com.example.myquizapp.Firebase_retrive_books;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myquizapp.Authintication.shared_profile;
import com.example.myquizapp.R;

public class Admin_profile extends AppCompatActivity {
    ImageView images;
    RelativeLayout mListview;
    TextView names, descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        images = findViewById(R.id.profile_image_id);
        mListview = findViewById(R.id.first_layout_id);
        names = findViewById(R.id.Name_person_id);
        descriptions = findViewById(R.id.Description_person_id);


        mListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin_profile.this, shared_profile.class);
//                startActivity(i);

                Pair[] pairs=new Pair[3];
                pairs[0]=new Pair<View,String>(images,"imagename");
                pairs[1]=new Pair<View,String>(names,"name");
                pairs[2]=new Pair<View,String>(descriptions,"Descriptionname");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Admin_profile.this,pairs);
                    startActivity(i,options.toBundle());
                }
            }
        });

    }
}
