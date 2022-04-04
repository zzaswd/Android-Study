package com.test.exam04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = findViewById(R.id.webView);

        String url = "www.google.com"; // 내 아이피.
        WebSettings webSettings = webView.getSettings(); // 웹 셋팅하는 방법.
        webSettings.setJavaScriptEnabled(true); // 웹서버에서 제공되는 js를 허용한다?
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        // 여기까지 하면 에러가 발생. Error1.img 참고
        // 안드로이드는 웹뷰를 사용하려면 manifest를 추가해줘야 함. 책 423p. 근데 이것도 옛날버전임.
        // 고치려면 다음과 같은 코드 추가.


        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });










    }
}