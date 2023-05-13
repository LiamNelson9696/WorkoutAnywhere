package com.example.multiplepages;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class WorkoutGenerator {

    WorkoutGenerator(){}

    public LinkedList generateWorkout(int intensity, String type)//, LinkedList<InputStream> files)
    {
        //linked list that will store all workouts
        LinkedList<Excercise> workout = new LinkedList<Excercise>();
        String x;

        //factory that will create workouts of each type
        ExcerciseGenerator factory = new ExcerciseGenerator();
        //default excercise object to be changed below
        Excercise m = new Excercise();

        //logic for the "push" type of workout: generates 2 chest, 2 shoulders, 1 tricep
        if(type == "push")
        {
            for(int i = 0; i < 2; i++)
            {
                //creates a new excercise
                m = factory.makeExcercise("chest");//, local);
                //sets the intensity
                m.setRepRange(intensity);
                //adds it to the workout
                workout.addLast(m);
            }
            for(int j = 0; j < 2; j++) //2
            {
                m = factory.makeExcercise("shoulders");//, local);
                m.setRepRange(intensity);
                workout.addLast(m);
            }
            m = factory.makeExcercise("triceps");//, local);
            m.setRepRange(intensity);
            workout.addLast(m);
        }
        else if(type == "pull")
        {
            for(int i = 0; i < 3; i++)
            {
                //creates a new excercise
                m = factory.makeExcercise("back");//, local);
                //sets the intensity
                m.setRepRange(intensity);
                //adds it to the workout
                workout.addLast(m);
            }
            for(int j = 0; j < 3; j++) //2
            {
                m = factory.makeExcercise("biceps");//, local);
                m.setRepRange(intensity);
                workout.addLast(m);
            }
        }
        else if(type == "legs")
        {
            for(int i = 0; i < 5; i++)
            {
                m = factory.makeExcercise("legs");
                m.setRepRange(intensity);
                workout.addLast(m);
            }
        }
        else if(type == "cardio")
        {
            for(int i = 0; i < 5; i++)
            {
                m = factory.makeExcercise("cardio");
                m.setRepRange(intensity);
                workout.addLast(m);
            }
        }
        return workout;
    }

} 