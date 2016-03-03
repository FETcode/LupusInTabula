package com.example.leonardo.lupusintabula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlayersPicker extends AppCompatActivity {

    //SeekBar to pick players' number
    private SeekBar seekBar;
    int progress = 0;

    //Displayed Numbers
    TextView villys;
    TextView specy;
    TextView clairvoyant;
    TextView amount;

    public static int wolves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_picker);
        initializeVariables();

        progress = 9;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                progress = progresValue + 9; //Lowest amount possible is 9
                amount.setText(String.format("%s", progress)); //Display the amount on change

                //If there are 16 or more players you got 3 wolves, otherwise 2
                if(progress > 15){
                    villys.setText(String.valueOf(5));
                    specy.setText(String.valueOf(3));
                    clairvoyant.setText(String.valueOf(1));

                    wolves = 3;

                }else{
                    villys.setText(String.valueOf(5));
                    specy.setText(String.valueOf(2));
                    clairvoyant.setText(String.valueOf(1));

                    wolves = 2;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    //When done, switch activity and enter players' names
    public void picker(View view){
        Intent intent = new Intent(this, PlayersNames.class);
        intent.putExtra("PLAYERS_LEFT", progress);
        startActivity(intent);
    }

        // A private method to help us initialize our variables.
        private void initializeVariables() {
            seekBar = (SeekBar) findViewById(R.id.seekBar);

            amount = (TextView) findViewById(R.id.amount);
            villys = (TextView) findViewById(R.id.villys);
            specy = (TextView) findViewById(R.id.specy);
            clairvoyant = (TextView) findViewById(R.id.clairvoyant);

            amount.setText(String.valueOf(9));
            villys.setText(String.valueOf(5));
            specy.setText(String.valueOf(2));
            clairvoyant.setText(String.valueOf(1));

            wolves = 0;
        }
    }

