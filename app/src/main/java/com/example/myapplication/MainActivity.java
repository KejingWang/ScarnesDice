package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    private int total_user = 0;
    private int turn_user = 0;
    private int total_comp = 0;
    private int turn_comp = 0;
    private ImageView dice;
    private TextView userText1;
    private TextView userText2;
    private TextView compText1;
    private TextView compText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice = findViewById(R.id.dice);
        userText1 = findViewById(R.id.userText1);
        userText2 = findViewById(R.id.userText2);
        compText1 = findViewById(R.id.compText1);
        compText2 = findViewById(R.id.compText2);

        userText1.setText("0");
        userText2.setText("0");
        compText1.setText("0");
        compText2.setText("0");
    }

    public void roll(View view) {
        int die = 1 + (int) (6 * Math.random());
        picChange(die);
        if (die != 1){
            turn_user = turn_user + die;
        } else {
            turn_user = 0;
        }
        userText2.setText(String.valueOf(turn_user));
    }

    public void compRoll(View view) {
        int die = 1 + (int) (6 * Math.random());
        picChange(die);
        while(turn_comp <20) {
            if (die != 1) {
                turn_comp = turn_comp + die;
            } else {
                turn_comp = 0;
            }
            userText2.setText(String.valueOf(turn_user));
        }
    }

    public void reset(View view){
        total_user = 0;
        turn_user = 0;
        total_comp = 0;
        turn_user = 0;
        userText1.setText("0");
        userText2.setText("0");
        compText1.setText("0");
        compText2.setText("0");
    }

    public void hold(View view){
        total_user = total_user + turn_user;
        turn_user = 0;
        System.out.print(total_user);
        userText1.setText(String.valueOf(total_user));
    }

    protected void picChange(int die) {
        switch (die) {
            case 1:
                dice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                break;
            case 2:
                dice.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                break;
            case 3:
                dice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                break;
            case 4:
                dice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                break;
            case 5:
                dice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                break;
            case 6:
                dice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                break;
        }
    }
}
