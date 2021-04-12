package com.example.sm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class JoinActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button check_btn, submit_btn;
        TextView J_id, J_pass, J_pass_cnf, J_name, J_email;

        check_btn = findViewById(R.id.check_btn);
        submit_btn = findViewById(R.id.join_submit_btn);
        J_id = findViewById(R.id.input_id);
        J_name = findViewById(R.id.input_name);
        J_pass = findViewById(R.id.input_pass);
        J_pass_cnf = findViewById(R.id.input_pass_confirm);
        J_email = findViewById(R.id.input_email);


        check_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), LoginActivity.class));
                finish();
            }
        });

    }
}