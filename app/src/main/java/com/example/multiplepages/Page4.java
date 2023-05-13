package com.example.multiplepages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Page4 extends Activity {
    Button btn;
    Button btn2, btn3, btn4;

    int selection = 2;

    //added
    SeekBar seekBar;
    TextView textView;
    TextView dMSG;  //diffuculty message


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);

        btn = (Button) findViewById(R.id.btn4);

        //added -- seek bar
        seekBar = (SeekBar)findViewById(R.id.seekBar2);//seekbar
        textView = (TextView)findViewById(R.id.myV);
        dMSG = (TextView)findViewById(R.id.textViewDM);

        //default message
        dMSG.setText("Average difficulty. For those seeking a solid workout.");

        //screen stuff
        View someView = findViewById(R.id.pg4);
        View root = someView.getRootView();
        root.setBackgroundColor(Color.parseColor("#aba17e"));
        //screen stuff layout
        final RelativeLayout relativeLayout;
        relativeLayout = findViewById(R.id.rlVar1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                InstanceManager.getInstance().difficulty = 3;   //used by default
                switch(progress){
                    case 0:
                        textView.setText("Easy");
                        relativeLayout.setBackgroundResource(R.color.r1);
                        dMSG.setText("For those seeking a quick and fun workout, but still want to get the blood pumping.");
                        InstanceManager.getInstance().difficulty = 1;   //lowest
                        break;
                    case 1:
                        textView.setText("Light");
                        relativeLayout.setBackgroundResource(R.color.r2);
                        dMSG.setText("For those seeking something not too easy, but not to difficult.");
                        InstanceManager.getInstance().difficulty = 2;
                        break;
                    case 2:
                        textView.setText("Moderate");
                        relativeLayout.setBackgroundResource(R.color.r3);
                        dMSG.setText("Average difficulty. For those seeking a solid workout.");
                        InstanceManager.getInstance().difficulty = 3;
                        break;
                    case 3:
                        textView.setText("Tough");
                        relativeLayout.setBackgroundResource(R.color.r4);
                        dMSG.setText("For those with experience who want to get a hard workout in!");
                        InstanceManager.getInstance().difficulty = 4;
                        break;
                    case 4:
                        textView.setText("Hardcore");
                        relativeLayout.setBackgroundResource(R.color.r5);
                        dMSG.setText("For the strongest! As tough as it gets.");
                        InstanceManager.getInstance().difficulty = 5;
                        break;
                    default:
                        InstanceManager.getInstance().difficulty = 3;

                }

            }
            //autogenerated methods
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        btn.setOnClickListener(new View.OnClickListener() { //change screens
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page4.this, Page5.class);

                startActivity(intent);
            }
        });


    }
}