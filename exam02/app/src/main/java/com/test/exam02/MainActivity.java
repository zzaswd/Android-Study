package com.test.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//   사용할 클래스 변수들을 만들어줘야 한다.

    ImageView imageView1;
    ImageView imageView2;

    Button btn_imgView;

    int imageIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        btn_imgView = findViewById(R.id.btn_imgView);

        btn_imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
            }
        });
    }

//    main 함수에서 이벤트 리스너가 동작하면 실행할 메서드를 선언해준다.
    //  프로젝트의 목적인 Image를 change하기 위해서 imageindex라는 변수를 사용했다.

    void changeImage(){
        if(imageIndex==0){
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        }

        else if(imageIndex==1){
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }



    }
}