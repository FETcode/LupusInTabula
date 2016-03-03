package com.example.leonardo.lupusintabula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //CREATE - CREATE//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    //CREATE - CREATE//

    public void playersPicker(View v) {
        Intent intent = new Intent(this, PlayersPicker.class);
        startActivity(intent);
    }
}
