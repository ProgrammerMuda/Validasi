package com.example.raga.validasi2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class spalshscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalshscreen);
        Handler adpHandler=new Handler();
        Runnable adprunnable= new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(spalshscreen.this,menu2.class));
                finish();

            }
        };
        adpHandler.postDelayed(adprunnable, 10000);
    }
}
