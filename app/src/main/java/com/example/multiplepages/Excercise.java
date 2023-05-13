package com.example.multiplepages;

public class Excercise {
    //name of excercise
    String name;
    //muscle group targeted (Chest), (Shouder), etc...
    String descriptor;
    //description of exercise
    String description;
    String prerequisites;
    //stores the lower-bound of the rep range, getting the upper bound by adding 2
    int repRange;
    int setRange;
    //weight to be lifted
    int load;

    //default constructor to create
    Excercise() {
        this.name = "parent";
        this.descriptor = "nullDescriptor";
        this.prerequisites = "nullPrereqs";
        this.repRange = 0;
        this.setRange = 0;
    }

    //sets rep range for the excersice based on the intensity
    void setRepRange(int intensity) {
        switch (intensity) {
            case 1:
                this.repRange = 6;
                break;
            case 2:
                this.repRange = 8;
                break;
            case 3:
                this.repRange = 10;
                break;
            case 4:
                this.repRange = 12;
                break;
            case 5:
                this.repRange = 14;
                break;
        }
    }

    String printExcercise()
    {
        System.out.println("("+this.descriptor+") "+this.name + ": "+this.setRange+ "x"+this.repRange+ " - "+this.load+" lbs");

        return this.name + ": "+this.setRange+ "x"+this.repRange+ " - "+this.load+" lbs";
    }

    String getDescription()
    {
        return this.description;
    }
};

//only one method
//makes excercises based on the based in "label", referred to as type
class ExcerciseGenerator
{
    //file object
    FileRead frReader = new FileRead();
    //name of the excercise
    String label = "n/a";
    String description = "n/a";

    ExcerciseGenerator() {}

    Excercise makeExcercise(String type){//, InputStream fr){
        Excercise test = new Excercise();
        String[] s = {"n/a","n/a"};

        if(type == "chest")
        {
            //saves the name of the excercise by calling the requestFile class with the file object
            //calls the constructor and passes the excercise name through
            s = frReader.requestFile("chest");
            label = s[0];
            description = s[1];
            test = new chestExcercise(label, description);
        }
        else if (type == "back")
        {
            s = frReader.requestFile("back");
            label = s[0];
            description = s[1];
            test = new backExcercise(label, description);
        }
        else if (type == "shoulders")
        {
            s = frReader.requestFile("shoulders");
            label = s[0];
            description = s[1];
            test = new shoulderExcercise(label, description);
        }
        else if (type == "biceps")
        {
            s = frReader.requestFile("biceps");
            label = s[0];
            description = s[1];
            test = new bicepExcercise(label, description);
        }
        else if (type == "triceps")
        {
            s = frReader.requestFile("triceps");
            label = s[0];
            description = s[1];
            test = new tricepExcercise(label, description);
        }
        else if (type == "legs")
        {
            s = frReader.requestFile("legs");
            label = s[0];
            description = s[1];
            test = new legsExcercise(label, description);
        }
        else if (type == "cardio")
        {
            s = frReader.requestFile("cardio");
            label = s[0];
            description = s[1];
            test = new cardioExercise(label, description);
        }

        return test;
    }
};


//all below are classes that contain the constructor for their specific muscle group
//they pass their file name to the file reader and assign the excercise name
class chestExcercise extends Excercise
{
    chestExcercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "chest";
        this.description = description;
        this.setRange = 3; //default value for now
        //calls the UserProfile singleton and calculates the load with a coefficent based on the mucsle group
        this.load = UserProfile.getInstance().calculateLoad(1);
    };
}

class shoulderExcercise extends Excercise
{
    shoulderExcercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "shoulders";
        this.description = description;
        this.setRange = 3; //default value for now
        this.load = UserProfile.getInstance().calculateLoad(.3);
    };
}

class tricepExcercise extends Excercise
{
    tricepExcercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "triceps";
        this.description = description;
        this.setRange = 3; //default value for now
        this.load = UserProfile.getInstance().calculateLoad(.2);
    };
}


class backExcercise extends Excercise
{
    backExcercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "back";
        this.description = description;
        this.setRange = 3; //default value for now
        this.load = UserProfile.getInstance().calculateLoad(.5);
    };
}

class bicepExcercise extends Excercise
{
    bicepExcercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "biceps";
        this.description = description;
        this.setRange = 3; //default value for now
        this.load = UserProfile.getInstance().calculateLoad(.2);
    };
}

class legsExcercise extends Excercise
{
    legsExcercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "legs";
        this.description = description;
        this.setRange = 3; //default value for now
        this.load = UserProfile.getInstance().calculateLoad(1.2);
    };
}

class cardioExercise extends Excercise
{
    cardioExercise(String label, String description)
    {
        this.name = label;
        this.descriptor = "cardio";
        this.description = description;
        this.setRange = InstanceManager.getInstance().difficulty; //default value for now
    };
}