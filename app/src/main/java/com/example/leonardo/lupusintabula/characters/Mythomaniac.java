package com.example.leonardo.lupusintabula.characters;

/**
 * Created by Leonardo on 13/01/2016.
 */
public class Mythomaniac extends Card {

    public Mythomaniac(){
        mCharacter = "Mythomaniac";
    }

    public static void copy(Class cls){
        try {
            Object obj = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}


