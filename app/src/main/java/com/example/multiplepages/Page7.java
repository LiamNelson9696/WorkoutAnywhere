package com.example.multiplepages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Page7 extends Activity {
    Button btn;
    TextView receiver_msg;
    TextView r1,r2,r3,r4,r5;
    String printout = "";
    //used for regenerating exc
    Button b1 ;
    Button b2 ;
    Button b3 ;
    Button b4 ;
    Button b5 ;

    //ExcerciseGenerator eGen = new ExcerciseGenerator();
    //Excercise e = new Excercise();
    WorkoutGenerator g = new WorkoutGenerator();
    LinkedList<Excercise> workout = new LinkedList<Excercise>();
    LinkedList<String> descriptors = new LinkedList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page7);

        LinkedList<Excercise> workout = new LinkedList<Excercise>();
        b1 = (Button) findViewById(R.id.rb1);
        b2 = (Button) findViewById(R.id.rb2);
        b3 = (Button) findViewById(R.id.rb3);
        b4 = (Button) findViewById(R.id.rb4);
        b5 = (Button) findViewById(R.id.rb5);


        //get / set elements of profile
        float weight;
        int height;
        boolean gender;
        String style;
        int intensity;
        boolean kb,bb,db;
        int start_wr, end_wr;

        weight = UserProfile.getInstance().getWeight();
        height = UserProfile.getInstance().getHeight();
        gender = UserProfile.getInstance().getGender();

        //have issues
        style = InstanceManager.getInstance().style;
        intensity = InstanceManager.getInstance().difficulty;


        kb = UserProfile.getInstance().kbAvailable;
        bb = UserProfile.getInstance().bbAvailable;
        db = UserProfile.getInstance().dbAvailable;
        start_wr = InstanceManager.getInstance().startW;
        end_wr = InstanceManager.getInstance().endW;

        //make correct profile
        UserProfile.getInstance().createProfile(weight, height, gender,  kb,  bb,  db, start_wr, end_wr);
        InstanceManager.getInstance().changeContext(this);


        System.out.println("Intensity:" + intensity);
        System.out.println("Type:" + style);
        workout = g.generateWorkout(intensity, style);//, files);


        InstanceManager.getInstance().workout = workout;
        for(int j = 0; j < workout.size(); j++)
        {
            printout += workout.get(j).printExcercise() + "\n";
            System.out.println(workout.get(j).getDescription());
            descriptors.add(workout.get(j).descriptor);
        }
        //test for
        for(int j = 0; j < workout.size(); j++) {
            {
                System.out.println("Descriptor: " +workout.get(j).descriptor);
            }
        }

        //added print all 5
        r1 = findViewById(R.id.received_value_id);
        r1.setText(workout.get(0).printExcercise());
        r2 = findViewById(R.id.received_value_id4);
        r2.setText(workout.get(1).printExcercise());
        r3 = findViewById(R.id.received_value_id5);
        r3.setText(workout.get(2).printExcercise());
        r4 = findViewById(R.id.received_value_id6);
        r4.setText(workout.get(3).printExcercise());
        r5 = findViewById(R.id.received_value_id7);
        r5.setText(workout.get(4).printExcercise());

        //saves user info to a text file
        try {
            FileRead fr = new FileRead();
            File path = this.getFilesDir();
            File newFile = new File(path, "userprofile.txt");
            fr.saveUserProfile(newFile.getAbsolutePath().toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ExcerciseGenerator eGen = new ExcerciseGenerator();
        InstanceManager.getInstance().e = new Excercise();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Var: "+ InstanceManager.getInstance().workout.get(0).descriptor);
                InstanceManager.getInstance().e = eGen.makeExcercise(descriptors.get(0));
                InstanceManager.getInstance().e.setRepRange(3);
                String s = InstanceManager.getInstance().e.printExcercise();
                r1.setText(s);
                InstanceManager.getInstance().workout.set(0, InstanceManager.getInstance().e);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InstanceManager.getInstance().e = eGen.makeExcercise(descriptors.get(1));
                InstanceManager.getInstance().e.setRepRange(3);
                String s = InstanceManager.getInstance().e.printExcercise();
                r2.setText(s);
                InstanceManager.getInstance().workout.set(1, InstanceManager.getInstance().e);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InstanceManager.getInstance().e = eGen.makeExcercise(descriptors.get(2));
                InstanceManager.getInstance().e.setRepRange(3);
                String s = InstanceManager.getInstance().e.printExcercise();
                r3.setText(s);
                InstanceManager.getInstance().workout.set(2, InstanceManager.getInstance().e);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InstanceManager.getInstance().e = eGen.makeExcercise(descriptors.get(3));
                InstanceManager.getInstance().e.setRepRange(3);
                String s = InstanceManager.getInstance().e.printExcercise();
                r4.setText(s);
                InstanceManager.getInstance().workout.set(3, InstanceManager.getInstance().e);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InstanceManager.getInstance().e = eGen.makeExcercise(descriptors.get(4));
                InstanceManager.getInstance().e.setRepRange(3);
                String s = InstanceManager.getInstance().e.printExcercise();
                r5.setText(s);
                InstanceManager.getInstance().workout.set(4, InstanceManager.getInstance().e);
            }
        });

        btn = (Button) findViewById(R.id.btn7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page7.this, Page8.class);
                //added: send excersises
                startActivity(intent);
            }
        });

    }
}
