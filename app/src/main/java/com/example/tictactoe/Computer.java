package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Computer extends AppCompatActivity {

    Animation top_a, bot_a, right_a;
    ImageView work;
    Button head;
    Button goBackside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        top_a = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bot_a = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        right_a = AnimationUtils.loadAnimation(this, R.anim.right_to_left);



        work = findViewById(R.id.imageView);
        head = findViewById(R.id.button4);
        goBackside = findViewById(R.id.button6);

        work.setAnimation(right_a);
        head.setAnimation(top_a);
        goBackside.setAnimation(bot_a);
    }

    public void buBack(View view) {

        Intent intent = new Intent(this, BichKaPage.class);
        startActivity(intent);
    }
}