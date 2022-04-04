package com.test.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView tv_sub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent(); // 값을 받는 intent
        String str = intent.getStringExtra("str"); // 받아왔던 str의 값을 str에 저장.
        
        tv_sub.setText(str); // str 값 출력

    }

}