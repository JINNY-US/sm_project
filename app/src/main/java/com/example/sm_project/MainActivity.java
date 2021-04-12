package com.example.sm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button go_to_likepage, go_to_review, go_to_mypage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_to_likepage = findViewById(R.id.go_to_likepage);
        go_to_review = findViewById(R.id.go_to_review);
        go_to_mypage = findViewById(R.id.go_to_mypage);

        go_to_likepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), LikepageActivity.class));
                finish();
            }
        });

        go_to_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), ReviewActivity.class));
                finish();
            }
        });

        go_to_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), MypageActivity.class));
                finish();
            }
        });


    }
}