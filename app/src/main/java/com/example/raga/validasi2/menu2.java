package com.example.raga.validasi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menu2 extends AppCompatActivity {
    Button btweb;
    Button btinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        btweb=(Button)findViewById(R.id.btnweb);
        btweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu2.this,Webview.class));
                Toast.makeText(getApplicationContext(),"welcome to my website",Toast.LENGTH_SHORT).show();
            }
        });

        btinput=(Button)findViewById(R.id.inputdata);
        btinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu2.this,menu.class));
                Toast.makeText(getApplicationContext(),"input data mu",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
