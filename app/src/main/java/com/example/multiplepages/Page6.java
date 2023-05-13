package com.example.multiplepages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Page6 extends Activity {

    Button btn;
    EditText send_text; //used to get user input

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page6);
        btn = (Button) findViewById(R.id.btn6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page6.this, Page7.class);

                //store start
                send_text = findViewById(R.id.editTextNumber2);//
                String str = send_text.getText().toString();
                int f = Integer.valueOf(str);

                //store end
                send_text = findViewById(R.id.editTextNumber4);//
                String str2 = send_text.getText().toString();
                int f2 = Integer.valueOf(str);

                //send both to instance
                InstanceManager.getInstance().startW = f;
                InstanceManager.getInstance().endW = f2;


                startActivity(intent);
            }
        });
    }
}


