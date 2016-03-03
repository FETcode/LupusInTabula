package com.example.leonardo.lupusintabula.characters;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public String name;
    public List<Card> card = new ArrayList<Card>();

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card c) {
        card.add(c);
    }

}