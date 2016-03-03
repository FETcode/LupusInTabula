package com.example.leonardo.lupusintabula.characters;

/**
 * Created by Leonardo on 13/01/2016.
 */
public class Guard extends Card {

    public Guard(){
        mCharacter = "Guard";
    }

    public void defend(Card card, Boolean b){
        card.mDefended = b;
    }

}


