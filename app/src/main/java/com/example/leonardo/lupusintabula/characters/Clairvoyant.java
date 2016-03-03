package com.example.leonardo.lupusintabula.characters;

/**
 * Created by Leonardo on 13/01/2016.
 */
public class Clairvoyant extends Card {

    public Clairvoyant(){
        mCharacter = "Clairvoyant";
    }

    public static boolean point(Card d){
        return d.getClass() == Wolf.class;
    }
}


