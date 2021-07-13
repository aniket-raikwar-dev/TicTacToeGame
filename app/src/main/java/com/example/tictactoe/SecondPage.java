package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second_page);

        findViewById(R.id.alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SecondPage.this);
                builder.setTitle("Exit");
                builder.setMessage("Do You Really Want To Exit !");

                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                builder.create().show();
            }
        });


    }

    public void buClick(View view) {
        Button buSelected = (Button) view;
        int CellID = 0;
        switch ((buSelected.getId())) {

            case R.id.bu1:
                CellID = 1;
                break;

            case R.id.bu2:
                CellID = 2;
                break;

            case R.id.bu3:
                CellID = 3;
                break;

            case R.id.bu4:
                CellID = 4;
                break;

            case R.id.bu5:
                CellID = 5;
                break;

            case R.id.bu6:
                CellID = 6;
                break;

            case R.id.bu7:
                CellID = 7;
                break;

            case R.id.bu8:
                CellID = 8;
                break;

            case R.id.bu9:
                CellID = 9;
                break;

        }
        PlayGame(CellID, buSelected);
    }

    int ActivePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();

    void PlayGame(int CellID, Button buSelected) {
        Log.d("Player:", String.valueOf(CellID));

        if (ActivePlayer == 1) {
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.rgb(0, 128, 128));
            Player1.add(CellID);
            ActivePlayer = 2;

            //AutoPlay();

        } else if (ActivePlayer == 2) {
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.rgb(135, 206, 205));
            Player2.add(CellID);
            ActivePlayer = 1;
        }

        //buSelected.setEnabled(false);
        CheckWinner();
    }

    void CheckWinner() {
        int winner = -1;
        // Row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2;
        }


        // Row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2;
        }


        // Row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2;
        }


        // Column 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2;
        }


        // Column 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2;
        }


        // Column 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2;
        }

        if (winner != -1) {
            // We Have Winner
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is  WINNER", Toast.LENGTH_LONG).show();
            }

            if (winner == 2) {
                Toast.makeText(this, "Player 2 is  WINNER", Toast.LENGTH_LONG).show();
            }

        }
    }

    void AutoPlay() {
        ArrayList<Integer> EmptyCells = new ArrayList<Integer>();
        for (int cellID = 1; cellID < 10; cellID++) {
            if (!(Player1.contains(cellID) || Player2.contains(1))) {
                EmptyCells.add(cellID);

            }
        }
        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size()-0) + 0;
        int CellID = EmptyCells.get(RandIndex);
        Button buSelected;

        switch (CellID) {

            case 1:
                buSelected = (Button) findViewById(R.id.bu1);
                break;

            case 2:
                buSelected = (Button) findViewById(R.id.bu2);
                break;

            case 3:
                buSelected = (Button) findViewById(R.id.bu3);
                break;

            case 4:
                buSelected = (Button) findViewById(R.id.bu4);
                break;

            case 5:
                buSelected = (Button) findViewById(R.id.bu5);
                break;

            case 6:
                buSelected = (Button) findViewById(R.id.bu6);
                break;

            case 7:
                buSelected = (Button) findViewById(R.id.bu7);
                break;

            case 8:
                buSelected = (Button) findViewById(R.id.bu8);
                break;

            case 9:
                buSelected = (Button) findViewById(R.id.bu9);
                break;
            default:
                buSelected = (Button) findViewById(R.id.bu1);
                break;

        }
        PlayGame(CellID, buSelected);
    }

}