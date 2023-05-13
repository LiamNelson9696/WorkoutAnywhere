package com.example.multiplepages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.chip.Chip;

public class Page5 extends Activity {

    Button btn;

    Button btn2, btn3, btn4;
    boolean bb = false;
    boolean db = false;
    boolean kb = false;

    //added
    Chip chip1, chip2, chip3, chip4, chip5, chip6, chip7, chip8, chip9, chip10, chip11, chip12, chip13 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page5);

        btn = (Button) findViewById(R.id.btn5);

        chip1 = findViewById(R.id.chipCpp1);//Barbell
        chip2 = findViewById(R.id.chipCpp2);//Kettlebell
        chip3 = findViewById(R.id.chipCpp3);//Dumbell
        chip4 = findViewById(R.id.chipCpp4);//Row Machine
        chip5 = findViewById(R.id.chipCpp5);//Leg Extention
        chip6 = findViewById(R.id.chipCpp6);//Lat Pulldown
        chip7 = findViewById(R.id.chipCpp7);//Smith Machine
        chip8 = findViewById(R.id.chipCpp8);//Leg Curl
        chip9 = findViewById(R.id.chipCpp9);//Leg Press
        chip10 = findViewById(R.id.chipCpp10);//Cable Machine
        chip11 = findViewById(R.id.chipCpp11);//Fly Machine
        chip12 = findViewById(R.id.chipCpp12);//Shoulder Press
        chip13 = findViewById(R.id.chipCpp13);//Latteral Raise


        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().bbAvailable = true;
            }
        });
        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().kbAvailable = true;
            }
        });
        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().dbAvailable = true;
            }
        });
        chip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().rowMachine = true;
            }
        });
        chip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().legExtensionMachine = true;
            }
        });
        chip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().latPulldownMachine = true;
            }
        });
        chip7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().smithMachine = true;
            }
        });
        chip8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().legCurlMachine = true;
            }
        });
        chip9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().legPressMachine = true;
            }
        });
        chip10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().cableMachine = true;
            }
        });
        chip11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().machineFly = true;
            }
        });
        chip12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().shoulderPressMachine = true;
            }
        });
        chip13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfile.getInstance().lateralRaiseMachine = true;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {//change screens
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page5.this, Page6.class);

                startActivity(intent);
            }
        });



    }
}
