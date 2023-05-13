package com.example.multiplepages;

import android.content.Context;

//contains all of the user profile data from first-time setup
public class UserProfile
{
    private static UserProfile userProfile;
    //weight in pounds
    private float weight;
    //height in inches
    private int height;
    //true = man, false = woman
    private boolean gender;

    //lower and upper range of available weights
    public int lowerRange;
    public int upperRange;

    public boolean kbAvailable;
        public boolean bbAvailable;
    public boolean dbAvailable;
    public boolean rowMachine;
    public boolean legExtensionMachine;
    public boolean latPulldownMachine;
    public boolean smithMachine;
    public boolean legCurlMachine;
    public boolean legPressMachine;
    public boolean cableMachine;
    public boolean shoulderPressMachine;
    public boolean lateralRaiseMachine;
    public boolean machineFly;



    //singleton used to get the public UserProfile info to other classes
    public static UserProfile getInstance()
    {
        if(userProfile == null)
        {
            userProfile = new UserProfile();
        }
        return userProfile;
    }

    //needed to convert feet+inches into inches
    int convertHeight(int feet, int inches)
    {
        int totalInches;
        totalInches = inches + (12*feet);
        return totalInches;
    }

    //creates the user profile on first-time use of app
    void createProfile(float w, int feet, int inches, boolean g, boolean kb, boolean bb, boolean db, int lowerRange, int upperRange)
    {
        //weight in pounds, height in inches
        this.weight = w;
        this.height = convertHeight(feet,inches);
        this.gender = g;
        kbAvailable = kb;
        bbAvailable = bb;
        dbAvailable = db;
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    void createProfile(float w, int height, boolean g, boolean kb, boolean bb, boolean db, int lowerRange, int upperRange)
    {
        //weight in pounds, height in inches
        this.weight = w;
        this.height = height;
        this.gender = g;
        kbAvailable = kb;
        bbAvailable = bb;
        dbAvailable = db;
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    //allows user to update their weight as it changes
    void updateWeight(float w)
    {
        this.weight = w;
    }
    //allows user to update the available equipment [currently unused]
    void updateGym(boolean kbAvailable, boolean bbAvailable, boolean dbAvailable, int lowerRange, int upperRange,
                   boolean legExtensionMachine, boolean latPulldownMachine, boolean smithMachine, boolean legCurlMachine, boolean rowMachine,
                   boolean legPressMachine, boolean cableMachine, boolean shoulderPressMachine, boolean lateralRaiseMachine, boolean machineFly) {

        this.kbAvailable = kbAvailable;
        this.bbAvailable = bbAvailable;
        this.dbAvailable = dbAvailable;
        this.upperRange = upperRange;
        this.lowerRange = lowerRange;
        this.legExtensionMachine = legExtensionMachine;
        this.latPulldownMachine = latPulldownMachine;
        this.smithMachine = smithMachine;
        this.legCurlMachine = legCurlMachine;
        this.rowMachine = rowMachine;
        this.legPressMachine = legPressMachine;
        this.cableMachine = cableMachine;
        this.shoulderPressMachine = shoulderPressMachine;
        this.lateralRaiseMachine = lateralRaiseMachine;
        this.machineFly = machineFly;
    }
    //calculates the weight load [used in Exercise children classes]
    int calculateLoad(double groupFactor)
    {
        int load = (int) (weight*.8*groupFactor);

        if(load > upperRange)
        {
            return upperRange;
        }
        else if(load < lowerRange)
        {
            return lowerRange;
        }
        else
        {
            load = load - (load % 5);
            return load;
        }
    }
    //[currently unused]
    float getWeight()
    {
        return weight;
    }
    //[currently unused]
    int getHeight()
    {
        return height;
    }
    //[currently unused]
    boolean getGender()
    {
        return gender;
    }

    void updateHeight(int height) {this.height = height;}

    void updateGender(boolean gender) {this.gender = gender;}
}