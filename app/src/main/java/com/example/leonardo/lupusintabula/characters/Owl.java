package com.example.leonardo.lupusintabula.characters;

/**
 * Created by Leonardo on 13/01/2016.
 */
public class Owl extends Card {

    public Owl(){
        mCharacter = "Owl";
    }

    public void owl(Card card, boolean b){
        card.mOwled = b;
    }

    /*public static void setOwled (Object theElem) {
        if (theElem instanceof Masons) {
            Masons elem = (Masons) theElem;
            elem.setIsOwled();
        }else if (theElem instanceof Demoniac) {
            Demoniac elem = (Demoniac) theElem;
            elem.setIsOwled();
        }else if (theElem instanceof Mythomaniac) {
            Mythomaniac elem = (Mythomaniac) theElem;
            elem.setIsOwled();
        }
        else if (theElem instanceof Guard) {
            Guard elem = (Guard) theElem;
            elem.setIsOwled();
        }
        else if (theElem instanceof Werehamster) {
            Werehamster elem = (Werehamster) theElem;
            elem.setIsOwled();
        }
        else if (theElem instanceof Medium) {
            Medium elem = (Medium) theElem;
            elem.setIsOwled();
        }
        else if (theElem instanceof Wolf) {
            Wolf elem = (Wolf) theElem;
            elem.setIsOwled();
        }
        else if (theElem instanceof Villager) {
            Villager elem = (Villager) theElem;
            elem.setIsOwled();
        }

    }*/

}

