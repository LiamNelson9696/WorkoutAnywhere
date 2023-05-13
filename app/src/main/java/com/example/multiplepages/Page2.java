package com.example.multiplepages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class Page2 extends Activity {

    Button btn;
    EditText send_text; //used to get user input

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_page);

        btn = (Button)findViewById(R.id.btn2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page2.this, Page3.class);

                //added: store data - starting with weight
                send_text = findViewById(R.id.myWeight);//weight
                String str = send_text.getText().toString();
                Float f = Float.valueOf(str);
                UserProfile.getInstance().updateWeight(f);

                //store height
                //height feet
                send_text = findViewById(R.id.myHeight);//height(feet)
                String str2 = send_text.getText().toString();
                int f2 = Integer.valueOf(str);
                //height inches
                send_text = findViewById(R.id.myHeight2);//height(inches)
                str2 = send_text.getText().toString();
                int f3 = Integer.valueOf(str);
                //convert to inches
                int totalInches;
                totalInches = f3 + (12*f2);

                UserProfile.getInstance().updateHeight(totalInches);

                //store gender
                boolean mf = false;
                Switch gd = (Switch) findViewById(R.id.switchMF);//cardio
                if(gd.isChecked())
                    mf = true;
                else
                    mf = false;
                UserProfile.getInstance().updateGender(mf);

                //start new activity

                startActivity(intent);
            }
        });
    }
}
