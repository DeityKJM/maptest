package com.handroid.mytownamp.maptest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;
/**
 * Created by kkang
 * 깡샘의 안드로이드 프로그래밍 - 루비페이퍼
 * 위의 교제에 담겨져 있는 코드로 설명 및 활용 방법은 교제를 확인해 주세요.
 */
public class MainActivity extends AppCompatActivity {
    TextView titleView;
    TextView dateView;
    TextView contentView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView=(TextView)findViewById(R.id.lab1_title);
        dateView=(TextView)findViewById(R.id.lab1_date);
        contentView=(TextView)findViewById(R.id.lab1_content);
        imageView=(ImageView)findViewById(R.id.lab1_image);



        HttpRequester httpRequester=new HttpRequester();
        httpRequester.request("http://13.124.1.90:3000/api/allCeo", httpCallback);
        Log.d("test1","tasking!");

    }

    HttpCallback httpCallback=new HttpCallback() {
        @Override
        public void onResult(String result) {
            try{
                Log.d("test1","success!");
                JSONObject root=new JSONObject(result);
                Log.d("test1","result = "+result);
                titleView.setText(root.getString("title"));
                dateView.setText(root.getString("date"));
                contentView.setText(root.getString("content"));

                String imageFile=root.getString("file");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };



}
