package com.example.multiplepages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn1);  //top button
        btn2 = (Button)findViewById(R.id.bfl);  //bottom button

        btn.setOnClickListener(new View.OnClickListener() { //start a new workout
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Page3.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {    //edit physical profile
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Page2.class); //move to page 2
                startActivity(intent);
            }
        });
    }
}