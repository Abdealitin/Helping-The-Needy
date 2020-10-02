package com.example.helptheneedy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.helptheneedy.R;

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
                    sleep(3000);
                }catch (Exception c){
                    c.printStackTrace();
                }finally {
                    Intent intent= new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }
}