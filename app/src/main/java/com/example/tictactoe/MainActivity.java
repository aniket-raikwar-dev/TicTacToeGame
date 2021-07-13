package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation topAnim, botAnim;
    ImageView image_1;
    ImageView image_2;
    ImageView image_3;
    ImageView image_4;
    Button buHeading;
    Button buStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image_1 = findViewById(R.id.imageView11);
        image_2 = findViewById(R.id.imageView13);
        image_3 = findViewById(R.id.imageView14);
        image_4 = findViewById(R.id.imageView15);
        buHeading = findViewById(R.id.button5);
        buStart = findViewById(R.id.button);


        image_1.setAnimation(topAnim);
        image_2.setAnimation(botAnim);
        image_3.setAnimation(botAnim);
        image_4.setAnimation(botAnim);
        buHeading.setAnimation(topAnim);
        buStart.setAnimation(botAnim);



    }

    public void buStart(View view) {
        Intent intent = new Intent(this, BichKaPage.class);
        startActivity(intent);
    }
}