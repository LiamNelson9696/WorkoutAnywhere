package com.example.multiplepages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class Page3 extends Activity {

    Button btn;
    Button btn2,btn3,btn4,btn5;
    int selection = 1;
    String sel = "push";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        btn = (Button)findViewById(R.id.btn3);  //used to move to next page

        Switch simpleSwitch8 = (Switch) findViewById(R.id.switch8);//core
        Switch simpleSwitch9 = (Switch) findViewById(R.id.switch9);//full body
        Switch simpleSwitch10 = (Switch) findViewById(R.id.switch10);//push

        if(simpleSwitch8.isChecked())
            InstanceManager.getInstance().style = "pull";
        if(simpleSwitch9.isChecked())
            InstanceManager.getInstance().style = "legs";
        if(simpleSwitch10.isChecked())
            InstanceManager.getInstance().style = "push";

        //Change screens
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page3.this, Page4.class);
                if(simpleSwitch8.isChecked())
                    InstanceManager.getInstance().style = "pull";   //pull
                if(simpleSwitch9.isChecked())
                    InstanceManager.getInstance().style = "legs";   //legs
                if(simpleSwitch10.isChecked())
                    InstanceManager.getInstance().style = "push";   //push


                startActivity(intent);
            }
        });
    }
}
