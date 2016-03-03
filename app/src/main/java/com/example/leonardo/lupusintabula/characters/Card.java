package com.example.leonardo.lupusintabula.characters;

/**
 * Created by Leonardo on 05/02/2016.
 */
public class Card {

    //Names
    public String mCharacter;

    //Status
    private boolean mAlive;
    private boolean mDefended;
    private boolean mOwled;
    private boolean mLastSavaged;
    private boolean mLastLynched;


    //Constructor
    public Card(){
    }

    public void setMCharacter(String value){
        this.mCharacter = value;
    }

    public void setMAlive(boolean alive){
        this.mAlive = alive;
    }

    public String getMCharacter(){
        return mCharacter;
    }

    public boolean getMAlive(){
        return mAlive;
    }

}
