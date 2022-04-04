package com.test.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    xml파일에서 선언했던 위젯들의 고유 아이디 불러오기

    EditText et_id;
    Button btn_test;

    EditText et_test;
    Button btn_move;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        안드로이드의 가장 기본적인 룰.
        et_id = findViewById(R.id.et_id); // et_id를 초기화.R은 리소스를 의미.
        btn_test = findViewById(R.id.btn_test); // btn_test를 초기화.


        et_test = findViewById(R.id.et_test);
        btn_move = findViewById(R.id.btn_move);


        // 이벤트 핸들러 : 특정 이벤트가 발생하는 것을 기다리는 리스너.
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기에 버튼이 눌렸을 때 발생할 행동들을 정의.
                et_id.setText("어서오세욧");

            }
        });

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // move 버튼 클릭했을 때 일어나는 행위(페이지 이동)
                //str = et_test.getText(); getText 반환값이 string이 아니라서 에러 발생
                str = et_test.getText().toString();
                Intent intent = new Intent(MainActivity.this,SubActivity.class); // 인자 두개가 필요한데, 하나는 지금 있는 클래스, 하나는 옮겨갈 클래스.
                intent.putExtra("str",str);
                startActivity(intent); // 값을 넘겨주는 함수였다.
            }
        });
    }
}