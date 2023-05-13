package com.example.multiplepages;

import android.content.Context;

import java.util.LinkedList;

public class InstanceManager {

    private static InstanceManager instanceManager;

    private Context c;

    public LinkedList<Excercise> workout;
    public LinkedList<String> descriptors;
    public Excercise e;

    public int example;
    public String style;
    public int difficulty = 3;
    public int startW;
    public int endW;

    public ExcerciseGenerator eGen;


    public static InstanceManager getInstance()
    {
        if(instanceManager == null)
        {
            instanceManager = new InstanceManager();
        }
        return instanceManager;
    }

    public void changeContext(Context c)
    {
        this.c = c;
    }

    public boolean isValidNumber(String input)
    {
        try
        {
            Float f2 = Float.valueOf(input);
            if(f2 > 1.0)
                return true; //if it's a non negative number
            else
                return false;
        }
        catch(Exception e)
        {
            return false; //if valueOf isn't a number at all, won't crash the program
        }
    }

    public Context getContext()
    {
        return c;
    }
}