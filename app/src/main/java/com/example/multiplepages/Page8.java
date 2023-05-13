package com.example.multiplepages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
//added
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class Page8 extends Activity {
    Button btn;

    //timer stuff
    final long START_TIME_IN_MILLIS = 120000; //used temporarily, subject to change
    TextView cd;
    Button sp;
    Button reset;
    CountDownTimer cdt;
    boolean tr;
    long timeLeft = START_TIME_IN_MILLIS;

    //added: text view
    TextView textView;
    //added: index
    int index = 1;

    //stuff for descriptors
    TextView td;
    Button moreInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.page8);

        //added-- display   -----------------------------------------------------
        textView = findViewById(R.id.excs);
        //added ends  -------------------------------------------------------

        textView.setText(InstanceManager.getInstance().workout.get(0).printExcercise());

        cd = findViewById(R.id.text_view_countdown);
        sp = findViewById(R.id.button_start_pause);
        reset = findViewById(R.id.button_reset);

        //start/pause
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tr)
                {

                    pauseTimer();
                }
                else
                {

                    startTimer();
                }
            }
        });
        //reset
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetTimer();
            }
        });

        updateCountDownText();


        //move to next screen
        btn = (Button) findViewById(R.id.btn8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page8.this, Page9.class);
                startActivity(intent);
            }
        });
        // added: next e
        Button btnNE;   //next excersise
        btnNE = (Button)findViewById(R.id.nextE); //used for push workout
        btnNE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(InstanceManager.getInstance().workout.get(index).printExcercise());
                index++;
            }
        });
        //screen transition stuff
        moreInfo = (Button)findViewById(R.id.buttonMI);
        //td.setText(InstanceManager.getInstance().workout.get(index).getDescription());
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                td=(TextView)findViewById(R.id.textViewH);
                td.setText(InstanceManager.getInstance().workout.get(index).getDescription());
                if(!td.isShown())  //Check if the view is currently visible or not.
                    td.setVisibility(View.VISIBLE);
                else
                    td.setVisibility(View.INVISIBLE);
            }
        });

        //move to next screen
        btn = (Button) findViewById(R.id.btn8);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page8.this, Page9.class);
                startActivity(intent);
            }
        });
    }
    //methods used in above
    private void startTimer()
    {
        cdt = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long milisUntilFinished) {
                timeLeft = milisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                tr = false;
                sp.setText("Start");
                sp.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.VISIBLE);
            }
        }.start();

        tr = true;
        sp.setText("pause");
        reset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer()
    {
        cdt.cancel();
        tr = false;
        sp.setText("Start");
        reset.setVisibility(View.VISIBLE);
    }

    void resetTimer()
    {
        timeLeft = START_TIME_IN_MILLIS;
        updateCountDownText();
        reset.setVisibility(View.INVISIBLE);
        sp.setVisibility(View.VISIBLE);
    }

    void updateCountDownText()
    {
        int mins = ((int)timeLeft / 1000) / 60 ;
        int secs = ((int)timeLeft / 1000) % 60 ;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", mins, secs);
        cd.setText(timeLeftFormatted);

    }




}
