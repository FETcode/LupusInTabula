package com.example.leonardo.lupusintabula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharactersPicker extends AppCompatActivity {

    //Int max amount Characters, they'll be used to see how many there are missing
    int playersLeft;
    int playersAmount;
    int villagers = 7;
    int demoniac = 1;
    int guard = 1;
    int masons = 2;
    int medium = 1;
    int mythomaniac = 1;
    int owl = 1;
    int werehamster = 1;

    //Buttons to pick 'em up
    Button switcherButton;
    Button toGame;
    Button demoniacB;
    Button guardB;
    Button masonsB;
    Button mediumB;
    Button mythomaniacB;
    Button owlB;
    Button villagerB;
    Button werehamsterB;

    //Display the amount left of characters to choose and set at first the switcherButton to +
    TextView textLeft;
    boolean switcher = true;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_picker);
        initializeVariables();

        //Retrieving
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                playersLeft = Integer.parseInt(null);
            } else {
                playersLeft = extras.getInt("PLAYERS_LEFT");
            }
        } else {
            playersLeft = (int) savedInstanceState.getSerializable("PLAYERS_LEFT");
        }
        //Done retrieving


        //Checking & Setting playersLeft
        if(playersLeft > 15){
            playersAmount = 9;
            textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft));
        }else {
            playersAmount = 8;
            textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft));
        }
    }

    //VILLAGERS
    public void villager(View view){
        if(switcher){
            if(playersAmount < playersLeft && villagers > 0){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                villagers -= 1;
                if(villagers == 0) {
                    villagerB.setEnabled(false);
                }
            }
        }else{
            if(playersAmount > 1 && villagers < 7){
                    playersAmount--;
                    textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //REMOVES
                    villagers += 1;
                    if(villagers == 7) {
                    villagerB.setEnabled(false);
                }
            }
        }
        checkComplete();
    }

    //SPECIAL
    public void demoniac(View view){
        if(switcher){
            if(playersAmount < playersLeft && demoniac == 1){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                demoniac -= 1;
                demoniacB.setEnabled(false);
            }
        }else{
            if(playersAmount > 1 && demoniac == 0 ){
                playersAmount--;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                demoniac += 1;
                demoniacB.setEnabled(false);
            }
        }
        checkComplete();
    }
    public void guard(View view){
        if(switcher){
            if(playersAmount < playersLeft && guard == 1){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                guard -= 1;
                guardB.setEnabled(false);
            }
        }else{
            if(playersAmount > 1 && guard == 0 ){
                playersAmount--;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                guard += 1;
                guardB.setEnabled(false);
            }
        }
        checkComplete();
    }
    public void masons(View view){
        if(switcher){
            if(playersAmount < playersLeft && masons > 0 && playersAmount + masons <= playersLeft){
                playersAmount += 2;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                masons -= 2;
                if(masons == 0) {
                    masonsB.setEnabled(false);
                }
            }
        }else{
            if(playersAmount > 1 && masons < 2 ){
                playersAmount -= 2;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                masons += 2;
                if(masons == 2) {
                    masonsB.setEnabled(false);
                }
            }
        }
        checkComplete();
    }
    public void medium(View view){
        if(switcher){
            if(playersAmount < playersLeft && medium == 1){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                medium -= 1;
                mediumB.setEnabled(false);
            }
        }else{
            if(playersAmount > 1 && medium == 0 ){
                playersAmount--;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                medium += 1;
                mediumB.setEnabled(false);
            }
        }
        checkComplete();
    }
    public void mythomaniac(View view){
        if(switcher){
            if(playersAmount < playersLeft && mythomaniac == 1){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                mythomaniac -= 1;
                mythomaniacB.setEnabled(false);
            }
        }else{
            if(playersAmount > 1 && mythomaniac == 0 ){
                playersAmount--;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                mythomaniac += 1;
                mythomaniacB.setEnabled(false);
            }
        }

        checkComplete();
    }
    public void owl(View view){
        if(switcher){
            if(playersAmount < playersLeft && owl == 1){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                owl -= 1;
                owlB.setEnabled(false);
            }
        }else{
            if(playersAmount > 1 && owl == 0 ){
                playersAmount--;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                owl += 1;
                owlB.setEnabled(false);
            }
        }
        checkComplete();
    }
    public void werehamster(View view){
        if(switcher){
            if(playersAmount < playersLeft && werehamster == 1){
                playersAmount++;
                textLeft.setText(String.format("%s", playersAmount + " / " + playersLeft)); //ADDS
                werehamster -= 1;
                werehamsterB.setEnabled(false);
            }
        }else{
            if(playersAmount > 1 && werehamster == 0 ){
                playersAmount--;
                textLeft.setText(String.format("%s", playersAmount  + " / " + playersLeft)); //REMOVES
                werehamster += 1;
                werehamsterB.setEnabled(false);
            }
        }
        checkComplete();
    }


    //Check and is so, set complete
    public void checkComplete(){
        if(playersAmount == playersLeft){
            setComplete();
        }else{
            toGame.setEnabled(false);
        }
    }
    public void setComplete(){
        toGame.setEnabled(true);
        demoniacB.setEnabled(false);
        guardB.setEnabled(false);
        masonsB.setEnabled(false);
        mediumB.setEnabled(false);
        mythomaniacB.setEnabled(false);
        owlB.setEnabled(false);
        villagerB.setEnabled(false);
        werehamsterB.setEnabled(false);
    }

    //SetSwitcher, with all its rules
    public void setSwitcher(View view){
        if(switcher){
            invertorPlus();
            switcherButton.setText(R.string.switcherMinus);
            switcher = false;
        }else{
            invertorMinus();
            switcherButton.setText(R.string.switcherPlus);
            switcher = true;
        }
    }
    public void invertPlus(Button b, int amount){
        if(amount > 0){
            b.setEnabled(false);
            if(b == villagerB){
                if(villagers != 7) {
                    b.setEnabled(true);
                }
            }
        }else if(amount == 0){
            b.setEnabled(true);
        }
    }
    public void invertMinus(Button b, int amount){
        if(amount > 0){
            b.setEnabled(true);
        }else if(amount == 0){
            b.setEnabled(false);
        }
    }
    public void invertorPlus(){
        toGame.setEnabled(!toGame.isEnabled());
        invertPlus(demoniacB, demoniac);
        invertPlus(guardB, guard);
        invertPlus(masonsB, masons);
        invertPlus(mediumB, medium);
        invertPlus(mythomaniacB, mythomaniac);
        invertPlus(owlB, owl);
        invertPlus(villagerB, villagers);
        invertPlus(werehamsterB, werehamster);

    }
    public void invertorMinus(){
        toGame.setEnabled(!toGame.isEnabled());
        invertMinus(demoniacB, demoniac);
        invertMinus(guardB, guard);
        invertMinus(masonsB, masons);
        invertMinus(mediumB, medium);
        invertMinus(mythomaniacB, mythomaniac);
        invertMinus(owlB, owl);
        invertMinus(villagerB, villagers);
        invertMinus(werehamsterB, werehamster);
        checkComplete();
    }

    //When Done, create characters and start randomAssignment activity
    public void done(View view){
        Intent intent = new Intent(this, RandomAssignment.class);
        if(demoniac == 0) {
            intent.putExtra("DEMONIAC", 1 - demoniac);
        }if(guard == 0) {
            intent.putExtra("GUARD", 1 - guard);
        }if(masons == 0) {
            intent.putExtra("MASONS", 2 - masons);
        }if(medium == 0) {
            intent.putExtra("MEDIUM", 1 - medium);
        }if(mythomaniac == 0) {
            intent.putExtra("MYTHOMANIAC", 1 - mythomaniac);
        }if(owl == 0) {
            intent.putExtra("OWL", 1 - owl);
        }if(werehamster == 0) {
            intent.putExtra("WEREHAMSTER", 1 - werehamster);
        }
        intent.putExtra("VILLAGER", 12 - villagers);

        startActivity(intent);
    }

    private void initializeVariables() {
        textLeft = (TextView) findViewById(R.id.playersLeft);
        //Buttons
        toGame = (Button) findViewById(R.id.toGame);
        switcherButton = (Button) findViewById(R.id.switcher);
        demoniacB = (Button) findViewById(R.id.demoniac);
        guardB = (Button) findViewById(R.id.guard);
        masonsB = (Button) findViewById(R.id.masons);
        mediumB = (Button) findViewById(R.id.medium);
        mythomaniacB = (Button) findViewById(R.id.mythomaniac);
        owlB = (Button) findViewById(R.id.owl);
        villagerB = (Button) findViewById(R.id.villager);
        werehamsterB = (Button) findViewById(R.id.werehamster);
    }
}
