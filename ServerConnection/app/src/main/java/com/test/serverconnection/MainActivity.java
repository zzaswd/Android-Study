package com.test.serverconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.serverconnection.Member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv_json;
    private RecyclerView recyclerView;
    //private BoardAdapter boardAdapter;

    static List<Member> data;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_json = findViewById(R.id.tv_json);
        //recyclerView = findViewById(R.id.recyclerView);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String page = "http://10.10.141.54:8080/android/memberList";

                try {
                    URL url = new URL(page);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    StringBuilder stringBuilder = new StringBuilder();

                    if(conn != null){

                        conn.setConnectTimeout(10000);
                        conn.setRequestMethod("GET");
                        conn.setUseCaches(false);
                        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){

                            // 입출력 스트림 연결하여 저장.
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                            while(true){
                                // 라인별로 받아와서 스트링별로 나눈다.
                                String line = bufferedReader.readLine();
                                if(line == null) break;
                                stringBuilder.append(line + "\n");
                            }
                            bufferedReader.close();
                        }
                        conn.disconnect();
                    }

                    tv_println("서버에서 받아온 JSON 타입의 String : " + "\n" + String.valueOf(stringBuilder));

                    tv_println("JSON Parsing 결과값");
                    Gson gson = new Gson();

                    Type type = new TypeToken<List<Member>>() {}.getType();
                    data = gson.fromJson(String.valueOf(stringBuilder),type);

                    String userid = data.get(2).getUserid();
                    String username = data.get(2).getUsername();
                    int age = data.get(2).getAge();

                    tv_println("아이디 : " + userid + ", 이름 : " + username + " ,나이 : " + age);
                    //tv_println("\nRecyclerView로 구현");


                    //rv_println(String.valueOf(stringBuilder));

                    //boardAdapter = new BoardAdapter(data);
                    //recyclerView.setAdapter(boardAdapter);
                    //recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } //End of run()

        }); //End of Thread
        thread.start();

    }
    public void tv_println(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv_json.append(data + "\n");
            }
        });
    }

}