package com.example.leonardo.lupusintabula.characters;

/**
 * Created by Leonardo on 13/01/2016.
 */
public class Wolf extends Card {

    public Wolf(){
        mCharacter = "Wolf";
    }

        public void savage(Card card) {
            card.mAlive = false;
        }

    }


