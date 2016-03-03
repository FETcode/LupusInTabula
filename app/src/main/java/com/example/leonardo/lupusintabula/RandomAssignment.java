package com.example.leonardo.lupusintabula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leonardo.lupusintabula.characters.Card;
import com.example.leonardo.lupusintabula.characters.Clairvoyant;
import com.example.leonardo.lupusintabula.characters.Demoniac;
import com.example.leonardo.lupusintabula.characters.Guard;
import com.example.leonardo.lupusintabula.characters.Masons;
import com.example.leonardo.lupusintabula.characters.Medium;
import com.example.leonardo.lupusintabula.characters.Mythomaniac;
import com.example.leonardo.lupusintabula.characters.Owl;
import com.example.leonardo.lupusintabula.characters.Player;
import com.example.leonardo.lupusintabula.characters.Villager;
import com.example.leonardo.lupusintabula.characters.Werehamster;
import com.example.leonardo.lupusintabula.characters.Wolf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomAssignment extends AppCompatActivity {

    //Amounts
    int demoniacAmount;
    int guardAmount;
    int masonsAmount;
    int mediumAmount;
    int mythomaniacAmount;
    int owlAmount;
    int villagerAmount;
    int werehamsterAmount;

    //Used in for loops
    int i;

    //Cards
    Wolf wolfOne;
    Wolf wolfTwo;
    Wolf wolfThree;
    Clairvoyant clairvoyant;
    Demoniac demoniac;
    Guard guard;
    Masons masonOne;
    Masons masonTwo;
    Medium medium;
    Mythomaniac mythomaniac;
    Owl owl;
    Villager villagerOne;
    Villager villagerTwo;
    Villager villagerThree;
    Villager villagerFour;
    Villager villagerFive;
    Villager villagerSix;
    Villager villagerSeven;
    Villager villagerEight;
    Villager villagerNine;
    Villager villagerTen;
    Villager villagerEleven;
    Villager villagerTwelve;
    Werehamster werehamster;

    // Where the characters are stored
    private ArrayList<Card> villagerBundle;
    Button randomButton;
    Button gameButton;

    public static List<Card> characters;
    public static List<String> nameList;
    public static List<Player> players;
    int listIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_assignment);

        //Retrieving
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                demoniacAmount = Integer.parseInt(null);
                guardAmount = Integer.parseInt(null);
                masonsAmount = Integer.parseInt(null);
                mediumAmount = Integer.parseInt(null);
                mythomaniacAmount = Integer.parseInt(null);
                owlAmount = Integer.parseInt(null);
                villagerAmount = Integer.parseInt(null);
                werehamsterAmount = Integer.parseInt(null);
            } else {
                    demoniacAmount = extras.getInt("DEMONIAC");
                    guardAmount = extras.getInt("GUARD");
                    masonsAmount = extras.getInt("MASONS");
                    mediumAmount = extras.getInt("MEDIUM");
                    mythomaniacAmount = extras.getInt("MYTHOMANIAC");
                    owlAmount = extras.getInt("OWL");
                    werehamsterAmount = extras.getInt("WEREHAMSTER");
                    villagerAmount = extras.getInt("VILLAGER");

            }
        } else {
            demoniacAmount = (int) savedInstanceState.getSerializable("DEMONIAC");
            guardAmount = (int) savedInstanceState.getSerializable("GUARD");
            masonsAmount = (int) savedInstanceState.getSerializable("MASONS");
            mediumAmount = (int) savedInstanceState.getSerializable("MEDIUM");
            mythomaniacAmount = (int) savedInstanceState.getSerializable("MYTHOMANIAC");
            owlAmount = (int) savedInstanceState.getSerializable("OWL");
            villagerAmount = (int) savedInstanceState.getSerializable("VILLAGER");
            werehamsterAmount = (int) savedInstanceState.getSerializable("WEREHAMSTER");
        }
        //Done retrieving
        initializeVariables();
        createCharacters();
        run();
    }


    //CREATE CHARACTERS
    public void createCharacters() {
        if (demoniacAmount != 0) {
            demoniac = new Demoniac();

        }if (guardAmount != 0) {
            guard = new Guard();

        } if (mediumAmount != 0) {
            medium = new Medium();

        } if (mythomaniacAmount != 0) {
            mythomaniac = new Mythomaniac();

        } if (owlAmount != 0) {
            owl = new Owl();

        } if (werehamsterAmount != 0) {
            werehamster = new Werehamster();

        } if (masonsAmount != 0) {
            masonOne = new Masons();
            masonTwo = new Masons();

        } if (villagerAmount > 5) {
                villagerSix = new Villager();
                villagerBundle.add(villagerSix);

                if (villagerAmount > 6) {
                    villagerSeven = new Villager();
                    villagerBundle.add(villagerSeven);

                    if (villagerAmount > 7) {
                        villagerEight = new Villager();
                        villagerBundle.add(villagerEight);

                        if (villagerAmount > 8) {
                            villagerNine = new Villager();
                            villagerBundle.add(villagerNine);

                            if (villagerAmount > 9) {
                                villagerTen = new Villager();
                                villagerBundle.add(villagerTen);

                                if (villagerAmount > 10) {
                                    villagerEleven = new Villager();
                                    villagerBundle.add(villagerEleven);

                                    if (villagerAmount > 11) {
                                        villagerTwelve = new Villager();
                                        villagerBundle.add(villagerTwelve);

                                        Toast.makeText(RandomAssignment.this, "works", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                }
            }

        //Wolves
        if(PlayersPicker.wolves == 3){
            wolfThree = new Wolf();}
        wolfOne = new Wolf();
        wolfTwo = new Wolf();

        clairvoyant = new Clairvoyant();
    }


    public Card getVillagerBundle(){
        int i = 0;
        do{return villagerBundle.get(i);
        }
            while(i < villagerBundle.size());
    }



    //STORE CHARACTERS
    public void initDeck() {
        // Extract the numbers if you actually need them, otherwise, they just are constants

        addCharacter(demoniac, demoniacAmount, characters);
        addCharacter(guard, guardAmount, characters);
        addCharacter(medium, mediumAmount, characters);
        addCharacter(mythomaniac, mythomaniacAmount, characters);
        addCharacter(owl, owlAmount, characters);
        addCharacter(werehamster, werehamsterAmount, characters);
        addCharacter(getVillagerBundle(), villagerAmount, characters);
        if(masonsAmount != 0) {
            addCharacter(masonOne, 1, characters);
            addCharacter(masonTwo, 1, characters);}
        addCharacter(wolfOne, 1, characters);
        addCharacter(wolfTwo, 1, characters);
        if(PlayersPicker.wolves == 3){
        addCharacter(wolfThree, 1, characters);}
        addCharacter(clairvoyant, 1, characters);

        System.out.println("Characters: " + characters.size());
        for(int i = 0; i < characters.size(); i++){
            System.out.println(characters.get(i));
        }
        createPlayers();
        System.out.println("Players: " + players.size());

        assign();
    }

    public void addCharacter(Card card, int amount, List<Card> cards) {
        if (amount < 0) {
            throw new IllegalArgumentException("Must add a non-negative number of characters for " + card.mCharacter );
        }
        // Don't use '==' for Strings

        for (int i = 0; i < amount; i++) {
            cards.add(card);
        }
    }

    void run() {
        // initialize the characters
        initDeck();

        // shuffle them
        Collections.shuffle(characters);
        Collections.shuffle(players);

        //Display the 1st card
        randomButton.setText(players.get(0).card.get(0).mCharacter + " / " + players.get(0).name);
    }


    //CREATE AND STORE PLAYERS
    public void createPlayers(){
        if(nameList.size() == 24){
            Player playerTwentyfour = new Player(nameList.get(23));
            players.add(playerTwentyfour);
        }if(nameList.size() >= 23){
            Player playerTwentythree = new Player(nameList.get(22));
            players.add(playerTwentythree);
        }if(nameList.size() >= 22){
            Player playerTwentytwo = new Player(nameList.get(21));
            players.add(playerTwentytwo);
        }if(nameList.size() >= 21){
            Player playerTwentyone = new Player(nameList.get(20));
            players.add(playerTwentyone);
        }if(nameList.size() >= 20){
            Player playerTwenty = new Player(nameList.get(19));
            players.add(playerTwenty);
        }if(nameList.size() >= 19){
            Player playerNineteen = new Player(nameList.get(18));
            players.add(playerNineteen);
        }if(nameList.size() >= 18){
            Player playerEighteen = new Player(nameList.get(17));
            players.add(playerEighteen);
        }if(nameList.size() >= 17){
            Player playerSeventeen = new Player(nameList.get(16));
            players.add(playerSeventeen);
        }if(nameList.size() >= 16){
            Player playerSixteen = new Player(nameList.get(15));
            players.add(playerSixteen);
        }if(nameList.size() >= 15){
            Player playerFifteen = new Player(nameList.get(14));
            players.add(playerFifteen);
        }if(nameList.size() >= 14){
            Player playerFourteen = new Player(nameList.get(13));
            players.add(playerFourteen);
        }if(nameList.size() >= 13){
            Player playerThirteen = new Player(nameList.get(12));
            players.add(playerThirteen);
        }if(nameList.size() >= 12){
            Player playerTwelve = new Player(nameList.get(11));
            players.add(playerTwelve);
        }if(nameList.size() >= 11){
            Player playerEleven = new Player(nameList.get(10));
            players.add(playerEleven);
        }if(nameList.size() >= 10){
            Player playerTen = new Player(nameList.get(9));
            players.add(playerTen);
        }if(nameList.size() >= 9){
            Player playerOne = new Player(nameList.get(0));
            Player playerTwo = new Player(nameList.get(1));
            Player playerThree = new Player(nameList.get(2));
            Player playerFour = new Player(nameList.get(3));
            Player playerFive = new Player(nameList.get(4));
            Player playerSix = new Player(nameList.get(5));
            Player playerSeven = new Player(nameList.get(6));
            Player playerEight = new Player(nameList.get(7));
            Player playerNine = new Player(nameList.get(8));

            players.add(playerOne);
            players.add(playerTwo);
            players.add(playerThree);
            players.add(playerFour);
            players.add(playerFive);
            players.add(playerSix);
            players.add(playerSeven);
            players.add(playerEight);
            players.add(playerNine);
            System.out.println(players.size());
            System.out.println(players.size());
            System.out.println(players.size());

        }
    }

    //Assign a card to each player
    public void assign(){
            for(int i = 0; i < players.size(); i++)
            players.get(i).addCard(characters.get(i));
        }




    //Pick a random one and display it
    public void pick(View view){
            if (i < characters.size()) {
                System.out.print(players.get(i).card.get(0));
                randomButton.setText(players.get(i).card.get(0).mCharacter + " / " + players.get(i).name);
                i++;
            } else {
                randomButton.setVisibility(randomButton.GONE);
                gameButton.setVisibility(gameButton.VISIBLE);
            }
        }

    //Start game Activity
    public void game(View v){
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }



    private void initializeVariables() {
        randomButton = (Button) findViewById(R.id.randomButton);
        gameButton = (Button) findViewById(R.id.gameButton);
        i = 1;
        listIndex = 0;
        nameList = PlayersNames.nameList;
        villagerBundle = new ArrayList<>();
        characters = new ArrayList<Card>();
        players = new ArrayList<Player>();


        villagerOne = new Villager();
        villagerTwo = new Villager();
        villagerThree = new Villager();
        villagerFour = new Villager();
        villagerFive = new Villager();

        villagerBundle.add(villagerOne);
        villagerBundle.add(villagerTwo);
        villagerBundle.add(villagerThree);
        villagerBundle.add(villagerFour);
        villagerBundle.add(villagerFive);
    }

}

/*
public void addAll(){
    for(i = 0; i < all; i++){
        add(demoniac, "Demoniac");
        add(guard, "Guard");
        add(medium, "Medium");
        add(mythomaniac, "Mythomaniac");
        add(owl, "Owl");
        add(werehamster, "Werehamster");
        add(villager, "Villager");
        add(masons, "Masons");
    }

}

    public int add(int character, String name){
        if(character != 0 && name == "Villager"){
            for(t = 0; t < character; t++){
                i+=t;
                characters[i] = name;}
        }
        else if(character == 2 && name == "Masons"){
            characters[i] = name;
            i++;
            characters[i] = name;
            Toast.makeText(RandomAssignment.this, "works", Toast.LENGTH_SHORT).show();
        }else if(character != 0){
            characters[i] = name;
        }
        return i;
    }


    public void randomize(){
        Collections.shuffle(Arrays.asList(characters));
        for (int s = 1; s < characters.length; s++)
        {
            System.out.println(characters[s]);
        }

    }

    public void show(View view){
        for (int s = 1; s < characters.length; s++)
        {
            randomButton.setText(characters[s]);
        }
    }


    public void assign() {
        if(demoniac != 0){
            Demoniac demoniac = new Demoniac();

        }else if(guard != 0){
            Guard guard = new Guard();

        }else if(werehamster != 0){
            Werehamster werehamster = new Werehamster();

        }else if(medium != 0){
            Medium medium = new Medium();

        }else if(mythomaniac != 0){
            Mythomaniac mythomaniac = new Mythomaniac();

        }else if(owl != 0){
            Owl owl = new Owl();

        }else if(masons > 0){
            Masons masonone = new Masons();

            if(masons > 1){
                Masons masontwo = new Masons();}

            }else if(villager >= 5) {
                Villager villagerone = new Villager();
            Villager villagertwo = new Villager();
            Villager villagerthree = new Villager();
            Villager villagerfour = new Villager();
            Villager villagerfive = new Villager();

                if(villager > 5) {
                    Villager villagersix = new Villager();

                    if(villager > 6) {
                        Villager villagerseven = new Villager();

                        if(villager > 7) {
                            Villager villagereight = new Villager();

                            if(villager > 8) {
                                Villager villagernine = new Villager();

                                if(villager > 9) {
                                    Villager villagerten = new Villager();

                                    if(villager > 10) {
                                        Villager villagereleven = new Villager();

                                        if(villager > 11) {
                                            Villager villagertwelve = new Villager();

                                            Toast.makeText(RandomAssignment.this, "works", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }




                            // Get a random character
        System.out.println();
        Random rand = new Random(System.currentTimeMillis());
        int randPos = rand.nextInt(characters.size());
        System.out.printf("%d: %s\n", randPos, characters.get(randPos));

        randomButton.setText(characters.get(randPos));
*/