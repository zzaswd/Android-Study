package com.test.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView iv_test;
    ListView list;

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_test=  findViewById(R.id.iv_test);
        list = findViewById(R.id.list);

        // ListView로 데이터를 가져와서 보이게 하는 방법.
        List<String> data = new ArrayList<>(); // 동적 배열리스트를 만들기 위해 collection class 이용
        
//   안드로이드에서는 자바에서 쓰는 동적 list를 바로 쓸 수 없어서 변환하기 위해 어댑터 선언.
        // simple_list_item_1은 상수인데, 배열초기화를 담당하는 상수이다.
        ArrayAdapter<String>  arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        list.setAdapter(arrayAdapter);
        data.add("김철수");
        data.add("김현아");
        data.add("황민수");
        data.add("강시형");

        arrayAdapter.notifyDataSetChanged();



        iv_test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast 메세지 보이게 하는 방법

                Toast.makeText(getApplicationContext(),"안녕하세요 반가워요...",Toast.LENGTH_LONG).show();
                //Length가 사라지는 시간에 관련된 것. short로하면 금방 사라짐.


                

            }
        });




    }
}