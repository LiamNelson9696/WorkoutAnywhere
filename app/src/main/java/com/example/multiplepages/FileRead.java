package com.example.multiplepages;

import java.io.*;
import java.sql.Array;
import java.util.*;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

class FileRead extends Activity
{
    LinkedList<String> labels = new LinkedList<String>();
    LinkedList<String> descriptions = new LinkedList<String>();
    LinkedList<String> loggedFiles = new LinkedList<String>();
    String lastVisited;
    String toReturn = "n/a";

    FileRead(){};

    public InputStream requestInputStream(String requestType) {

        if(requestType == "chest")
        {
            return InstanceManager.getInstance().getContext().getResources().openRawResource(R.raw.chestexcercises);
        }
        else if(requestType == "back")
        {
            return InstanceManager.getInstance().getContext().getResources().openRawResource(R.raw.backexcercises);
        }
        else if(requestType == "biceps")
        {
            //change
            return InstanceManager.getInstance().getContext().getResources().openRawResource(R.raw.bicepsexcercises);
        }
        else if(requestType == "triceps")
        {
            return InstanceManager.getInstance().getContext().getResources().openRawResource(R.raw.tricepexcercises);
        }
        else if(requestType == "shoulders")
        {
            return InstanceManager.getInstance().getContext().getResources().openRawResource(R.raw.shoulderexcercises);
        }
        else if(requestType == "legs")
        {
            return InstanceManager.getInstance().getContext().getResources().openRawResource(R.raw.legsexcercises);
        }

        return null;
    }

    //labelMaker for final build
    void labelMaker(String excerciseList, InputStream fr)
    {
        lastVisited = excerciseList;
        Scanner reader = new Scanner(fr);
        String readFile;

        while(reader.hasNextLine())
        {
            readFile = reader.nextLine();

            if(UserProfile.getInstance().kbAvailable && readFile.contains("KB")) {
                labels.addLast(readFile.replace("KB", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().bbAvailable && readFile.contains("BB")) {
                labels.addLast(readFile.replace("BB", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().dbAvailable && readFile.contains("DB")) {
                labels.addLast(readFile.replace("DB", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().cableMachine && readFile.contains("CBM")) {
                labels.addLast(readFile.replace("CBM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().legExtensionMachine && readFile.contains("LEM")) {
                labels.addLast(readFile.replace("LEM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().smithMachine && readFile.contains("SMM")) {
                labels.addLast(readFile.replace("SMM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().latPulldownMachine && readFile.contains("LPM")) {
                labels.addLast(readFile.replace("LPM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().legCurlMachine && readFile.contains("LCM")) {
                labels.addLast(readFile.replace("LCM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().legPressMachine && readFile.contains("LLM")) {
                labels.addLast(readFile.replace("LLM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().cableMachine && readFile.contains("CMM")) {
                labels.addLast(readFile.replace("CMM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().machineFly && readFile.contains("MFM")) {
                labels.addLast(readFile.replace("MFM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().shoulderPressMachine && readFile.contains("SPM")) {
                labels.addLast(readFile.replace("SPM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
            else if(UserProfile.getInstance().lateralRaiseMachine && readFile.contains("LRM")) {
                labels.addLast(readFile.replace("LRM", ""));
                readFile = reader.nextLine();
                descriptions.addLast(readFile);
            }
        }
        reader.close();
    }

    public String[] requestFile(String fileName)
    {
        boolean inCache = false;
        String[] s= {"n/a","n/a"};

        if(labels.isEmpty())
        {
            labelMaker(fileName, requestInputStream(fileName));
        }
        else if(labels.isEmpty() == false && lastVisited != fileName)
        {
            while(labels.isEmpty() == false){
                labels.removeFirst();
                descriptions.removeFirst();
            }
            labelMaker(fileName, requestInputStream(fileName));
        }
        s[0] = labels.removeFirst();
        s[1] = descriptions.removeFirst();

        return s;
    }

    public String loadUserProfile(String fr1) throws FileNotFoundException {
        File readThis = new File(fr1);
        float weight;
        int height, upper, lower;
        boolean gender, bb, db, kb, legExtensionMachine, latPulldownMachine, smithMachine,
                legCurlMachine, rowMachine, legPressMachine, cableMachine, shoulderPressMachine, lateralRaiseMachine, machineFly;


        Scanner reader = new Scanner(readThis);

        weight = Integer.parseInt(reader.nextLine().replace("weight=",""));
        height = Integer.parseInt(reader.nextLine().replace("height=",""));

        if(reader.nextLine() == "gender=true")
            gender= true;
        else
            gender= false;

        if(reader.nextLine() == "bb=true")
            bb= true;
        else
            bb= false;

        if(reader.nextLine() == "db=true")
            db=true;
        else
            db=false;

        if(reader.nextLine() == "kb=true")
            kb=true;
        else
            kb=false;

        if(reader.nextLine() == "lem=true")
            legExtensionMachine = true;
        else
            legExtensionMachine = false;

        if(reader.nextLine() == "lpm=true")
            latPulldownMachine = true;
        else
            latPulldownMachine = false;

        if(reader.nextLine() == "smm=true")
            smithMachine = true;
        else
            smithMachine = false;

        if(reader.nextLine() == "lcm=true")
            legCurlMachine = true;
        else
            legCurlMachine = false;

        if(reader.nextLine() == "rmm=true")
            rowMachine = true;
        else
            rowMachine = false;

        if(reader.nextLine() == "llm=true")
            legPressMachine = true;
        else
            legPressMachine = false;

        if(reader.nextLine() == "cmm=true")
            cableMachine = true;
        else
            cableMachine = false;

        if(reader.nextLine() == "spm=true")
            shoulderPressMachine = true;
        else
            shoulderPressMachine = false;

        if(reader.nextLine() == "lrm=true")
            lateralRaiseMachine = true;
        else
            lateralRaiseMachine = false;

        if(reader.nextLine() == "mfm=true")
            machineFly = true;
        else
            machineFly = false;

        lower= Integer.parseInt(reader.nextLine().replace("lower=",""));
        upper= Integer.parseInt(reader.nextLine().replace("upper=",""));

        UserProfile.getInstance().createProfile(weight, height, gender, kb, bb, db, lower, upper);
        UserProfile.getInstance().updateGym(kb, bb, db, lower, upper, legExtensionMachine, latPulldownMachine,
                smithMachine, legCurlMachine, rowMachine, legPressMachine, cableMachine, shoulderPressMachine,
                lateralRaiseMachine, machineFly);

        return "success";
    }

    public String saveUserProfile(String fr1) throws IOException {
        File readThis = new File(fr1);
        FileOutputStream stream = new FileOutputStream(readThis);

        Scanner line = new Scanner(readThis);
        //System.out.println(fr1);
        //System.out.println(line.nextLine());
        String fileSave = "";
        System.out.println(String.valueOf(fr1));
        System.out.println("hello");

        fileSave += "weight="+String.valueOf(UserProfile.getInstance().getWeight())+"\n";
        fileSave += "height="+String.valueOf(UserProfile.getInstance().getHeight())+"\n";
        fileSave += "gender="+String.valueOf(UserProfile.getInstance().getGender())+"\n";
        fileSave += "bb="+String.valueOf(UserProfile.getInstance().bbAvailable)+"\n";
        fileSave += "db="+String.valueOf(UserProfile.getInstance().kbAvailable)+"\n";
        fileSave += "kb="+String.valueOf(UserProfile.getInstance().dbAvailable)+"\n";
        fileSave += "lem="+String.valueOf(UserProfile.getInstance().legExtensionMachine);
        fileSave += "lpm="+String.valueOf(UserProfile.getInstance().latPulldownMachine);
        fileSave += "smm="+String.valueOf(UserProfile.getInstance().smithMachine);
        fileSave += "lcm="+String.valueOf(UserProfile.getInstance().legCurlMachine);
        fileSave += "rmm="+String.valueOf(UserProfile.getInstance().rowMachine);
        fileSave += "llm="+String.valueOf(UserProfile.getInstance().legPressMachine);
        fileSave += "cmm="+String.valueOf(UserProfile.getInstance().cableMachine);
        fileSave += "spm="+String.valueOf(UserProfile.getInstance().shoulderPressMachine);
        fileSave += "lrm="+String.valueOf(UserProfile.getInstance().lateralRaiseMachine);
        fileSave += "mfm"+String.valueOf(UserProfile.getInstance().machineFly);
        fileSave += "lower="+String.valueOf(UserProfile.getInstance().lowerRange+"\n");
        fileSave += "upper="+String.valueOf(UserProfile.getInstance().upperRange+"\n");
        stream.write(fileSave.getBytes());
        stream.close();

        return "success";
    }
}