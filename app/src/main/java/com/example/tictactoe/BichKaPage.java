package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class BichKaPage extends AppCompatActivity {

    Animation topAnimation, botAnimation, leftAnim, rightAnim;
    ImageView imageView_1;
    ImageView imageView_3;
    ImageView imageView_5;
    ImageView ship;
    Button buP;
    Button buC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bich_ka_page);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.right_to_left);


        imageView_1 = findViewById(R.id.imageView7);
        imageView_3 = findViewById(R.id.imageView3);
        imageView_5 = findViewById(R.id.imageView5);
        ship = findViewById(R.id.imageView2);
        buP = findViewById(R.id.button2);
        buC = findViewById(R.id.button3);


        imageView_1.setAnimation(botAnimation);
        imageView_3.setAnimation(leftAnim);
        imageView_5.setAnimation(leftAnim);
        buP.setAnimation(rightAnim);
        buC.setAnimation(rightAnim);
        ship.setAnimation(leftAnim);
    }

    public void BuPlayer(View view) {

        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }

    public void buComp(View view) {
        Intent intent = new Intent(this, Computer.class);
        startActivity(intent);
    }

    public void buMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}