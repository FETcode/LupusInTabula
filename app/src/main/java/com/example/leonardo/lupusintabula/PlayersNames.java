package com.example.leonardo.lupusintabula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlayersNames extends AppCompatActivity {

    //Design
    EditText name;
    TextView text2;
    Button buttonUndo;
    Button buttonAdd;
    Button buttonNext;

    //Logic
    public static List<String> nameList;
    int playersAmount;
    int PLAYERS_AMOUNT;
    String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_names);

        //Retrieving
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                playersAmount = Integer.parseInt(null);
            } else {
                playersAmount = extras.getInt("PLAYERS_LEFT");
            }
        } else {
            playersAmount = (int) savedInstanceState.getSerializable("PLAYERS_LEFT");
        }
        //Done retrieving
        initializeVariables();
        buttonUndo.setEnabled(false);
    }

    //Add names
    public void add(View v){
        if(name.getText().toString().equals("")){
            Toast.makeText(PlayersNames.this, "Per favore aggiungi prima un nome", Toast.LENGTH_SHORT).show();
        }else if(playersAmount > 1) { //If there are PlayersLeft, add a name and subtract 1 to the playersAmount
            buttonUndo.setEnabled(true);
            nameList.add(name.getText().toString());
            name.setText("");
            playersAmount--;

            text2.setText(getString(R.string.formatted_string1, playersAmount)); //Display Multi
            if(playersAmount == 1){
                text2.setText(getString(R.string.formatted_string0, playersAmount)); //Display Single
            }

            System.out.println("[+] " + nameList.get(nameList.size() - 1));
            System.out.println("[+] " + nameList.size());
            System.out.println("[+] " + playersAmount);

        }else if(playersAmount == 1){ //If last, add the last name and then change the buttonAdd into buttonNext
            nameList.add(name.getText().toString());
            name.setText("");
            playersAmount--;

            text2.setText(R.string.complete); //Display Value

            name.setEnabled(false);
            buttonAdd.setVisibility(Button.GONE);
            buttonNext.setVisibility(Button.VISIBLE);
            Toast.makeText(PlayersNames.this, "Valid", Toast.LENGTH_SHORT).show();
        }

    }

    //Undo, remove last name
    public void undo(View v){
        System.out.println("[-]" + nameList.get(nameList.size() - 1));
        nameList.remove(nameList.size() - 1);
        System.out.println("[+] " + nameList.size());
        playersAmount++;
        System.out.println("[+] " + playersAmount);

        text2.setText(getString(R.string.formatted_string1, playersAmount)); //Display Value
        if(playersAmount == 1){
            text2.setText(getString(R.string.formatted_string0, playersAmount)); //display value
        }

        if(playersAmount == 1){ //If last, switch back from the buttonNext to the buttonAdd again
            name.setEnabled(true);
            buttonAdd.setVisibility(Button.VISIBLE);
            buttonNext.setVisibility(Button.GONE);
        }else if(nameList.size() == 0){ //If full, you can't undo
            buttonUndo.setEnabled(false);
        }
    }

    //Next, you're done
    public void next(View v){
        Intent intent = new Intent(this, CharactersPicker.class);
        intent.putExtra("PLAYERS_LEFT", PLAYERS_AMOUNT);
        startActivity(intent);

    }

    private void initializeVariables() {
        name = (EditText) findViewById(R.id.editText);
        text2 = (TextView) findViewById(R.id.text2);
        buttonUndo = (Button) findViewById(R.id.buttonUndo);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        nameList = new ArrayList<String>();
        temp = "";
        PLAYERS_AMOUNT = playersAmount;
        text2.setText(getString(R.string.formatted_string1, playersAmount)); //Display Multi
    }

}
