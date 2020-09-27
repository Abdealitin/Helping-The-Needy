package com.example.helptheneedy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                }catch (Exception c){
                    c.printStackTrace();
                }finally {
                    Intent intent= new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}