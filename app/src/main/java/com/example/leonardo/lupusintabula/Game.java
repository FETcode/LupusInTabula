package com.example.leonardo.lupusintabula;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.leonardo.lupusintabula.characters.Clairvoyant;
import com.example.leonardo.lupusintabula.characters.Guard;
import com.example.leonardo.lupusintabula.characters.Medium;
import com.example.leonardo.lupusintabula.characters.Mythomaniac;
import com.example.leonardo.lupusintabula.characters.Owl;
import com.example.leonardo.lupusintabula.characters.Wolf;
import com.example.leonardo.lupusintabula.RandomAssignment.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game extends ListActivity {

    int nightCount;
    int dayCount;
    int nightIndex;
    int dayIndex;
    int generalCount;
    int nextCount;

    Boolean nightOne;
    Boolean nightTwo;
    Boolean nightGeneral;
    Boolean dayOne;
    Boolean dayTwo;
    Boolean dayGeneral;

    ArrayAdapter<String> chatAdapter;

    Resources res;
    String[] dayString;
    String[] nightString;
    String[] masonsString;
    String[] wolvesString;
    String[] masterDeadString;
    String[] dialogueString;
    String[] votesOneString;
    String[] harangueString;
    String[] votesTwoString;
    String[] lynchingString;
    String[] clairvoyantString;
    String[] mediumString;
    String[] owlString;
    String[] guardString;
    String[] mythomaniacString;

    ListView chat;
    List<String> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initializeVariables();
        setListAdapter(chatAdapter);

    }


    public void next(View v) {
        if (nextCount == 1) {
            night();
        } else if (nextCount == 2) {
            checkEndGame();
            day();
        }
    }


    //NIGHT

    public void night() {
        if (nightCount == 3 && !nightGeneral) {
            nightGeneral();
        } else if (nightCount == 2 && !nightTwo) {
            nightTwo();
        } else {
            if(!nightOne) {
                nightOne();
            }
        }
    }


    public void nightOne() {
        if (generalCount == 1) {
            addChat("NIGHT 1");
            addChat(masonsString);
        } else if(generalCount == 2){
            addChat(wolvesString);
            generalCount = 0;
            nextCount++;
            nightCount++;
            nightOne = true;
        }
        generalCount++;
    }

    public void nightTwo() {
        if (generalCount == 1 && Clairvoyant.mAlive) {
            addChat("NIGHT 2");
            addChat(clairvoyantString);
        } else if (generalCount == 2 && ) {
            addChat(mediumString);
        } else if (generalCount == 3 && Owl.getmAlive()) {
            addChat(owlString);
        } else if(generalCount == 4 && Guard.mAlive){
            addChat(guardString);
        } else if(generalCount == 5 && Wolf.mAlive){
            addChat(wolvesString);
        }else if(generalCount == 6 && Mythomaniac.mAlive){
            addChat(mythomaniacString);
            generalCount = 0;
            nextCount++;
            nightCount++;
            nightTwo = true;
        }
        generalCount++;
    }

    public void nightGeneral() {
        if (generalCount == 1 && Clairvoyant.mAlive) {
            addChat("NIGHT 3");
            addChat(clairvoyantString);
        } else if (generalCount == 2 && Medium.mAlive) {
            addChat(mediumString);
        } else if (generalCount == 3 && Owl.mAlive) {
            addChat(owlString);
        } else if(generalCount == 4 && Guard.mAlive){
            addChat(guardString);
        } else if(generalCount == 5 && Wolf.mAlive){
            addChat(wolvesString);
        }else if(generalCount == 6 && Mythomaniac.mAlive){
            addChat(mythomaniacString);
            generalCount = 0;
            nextCount++;
            nightCount++;
            nightGeneral = true;
        }
        generalCount++;
    }

    //DAY

    public void day() {
        if (dayCount == 3 && !dayGeneral) {
            dayGeneral();
        } else if (dayCount == 2 && !dayTwo) {
            dayTwo();
        } else {
            if(!dayOne) {
                dayOne();
            }
        }
    }

    public void dayOne(){
        if (generalCount == 1) {
            addChat("DAY 1");
            addChat(masterDeadString);
        } else if (generalCount == 2) {
            addChat(dialogueString);
        } else if (generalCount == 3) {
            addChat(votesOneString);
        } else if(generalCount == 4){
            addChat(harangueString);
        } else if(generalCount == 5){
            addChat(votesTwoString);
        }else if(generalCount == 6){
            addChat(lynchingString);
            generalCount = 0;
            nextCount = 1;
            dayCount++;
            dayOne = true;
        }
        generalCount++;
    }

    public void dayTwo(){
        if (generalCount == 1) {
            addChat("DAY 2");
            addChat(masterDeadString);
        } else if (generalCount == 2) {
            addChat(dialogueString);
        } else if (generalCount == 3) {
            addChat(votesOneString);
        } else if(generalCount == 4){
            addChat(harangueString);
        } else if(generalCount == 5){
            addChat(votesTwoString);
        }else if(generalCount == 6){
            addChat(lynchingString);
            generalCount = 0;
            nextCount = 1;
            dayCount++;
            dayTwo = true;
        }
        generalCount++;
    }

    public void dayGeneral(){
        if (generalCount == 1) {
            addChat("DAY 3");
            addChat(masterDeadString);
        } else if (generalCount == 2) {
            addChat(dialogueString);
        } else if (generalCount == 3) {
            addChat(votesOneString);
        } else if(generalCount == 4){
            addChat(harangueString);
        } else if(generalCount == 5){
            addChat(votesTwoString);
        }else if(generalCount == 6){
            addChat(lynchingString);
            generalCount = 0;
            nextCount = 1;
            dayCount++;
            dayGeneral = true;
        }
        generalCount++;
    }

    //[Methods]

    //Write on the ListView
    public void addChat(String[] message){
            chatList.add(message[randInt(0, 3)]);
            chatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chatList);
            chat.setAdapter(chatAdapter);
            chat.setSelection(chat.getAdapter().getCount()-1);
    }

    public void addChat(String message){
        chatList.add(message);
        chatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chatList);
        chat.setAdapter(chatAdapter);
        chat.setSelection(chat.getAdapter().getCount() - 1);
    }


    //Generate random ints
    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }




    public void checkEndGame(){
        if(wolfOne.mAlive)
    }




    //Initialize variables
    private void initializeVariables() {
        chat = (ListView) findViewById(android.R.id.list);
        chatList = new ArrayList<String>();
        chatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chatList);


        res = getResources();
        nightString = res.getStringArray(R.array.night);
        dayString = res.getStringArray(R.array.day);
        masonsString = res.getStringArray(R.array.masons);
        wolvesString = res.getStringArray(R.array.wolves);
        masterDeadString = res.getStringArray(R.array.masterDead);
        dialogueString = res.getStringArray(R.array.dialogue);
        votesOneString = res.getStringArray(R.array.votesTwo);
        harangueString = res.getStringArray(R.array.harangue);
        votesTwoString = res.getStringArray(R.array.votesTwo);
        lynchingString = res.getStringArray(R.array.lynching);
        clairvoyantString = res.getStringArray(R.array.clairvoyant);
        mediumString = res.getStringArray(R.array.medium);
        owlString = res.getStringArray(R.array.owl);
        guardString = res.getStringArray(R.array.guard);
        mythomaniacString = res.getStringArray(R.array.mythomaniac);

        nightOne = false;
        nightTwo = false;
        nightGeneral = false;
        dayOne = false;
        dayTwo = false;
        dayGeneral = false;

        nextCount = 1;
        generalCount = 1;
        nightCount = 1;
        dayCount = 1;

    }
}
