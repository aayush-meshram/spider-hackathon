package com.applications.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity2 extends AppCompatActivity {

    public ImageButton buttonHighlight;
    public ImageButton buttonScience;
    public ImageButton buttonGaming;
    public ImageButton buttonMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHighlight = findViewById(R.id.image_button_1);
        buttonScience = findViewById(R.id.image_button_2);
        buttonGaming = findViewById(R.id.image_button_3);
        buttonMovies = findViewById(R.id.image_button_4);

        buttonHighlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAwayImageButton();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("tabNo", 0);
                startActivity(intent);

            }
        });

        buttonScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAwayImageButton();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("tabNo", 1);
                startActivity(intent);

            }
        });

        buttonGaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAwayImageButton();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("tabNo", 2);
                startActivity(intent);

            }
        });

        buttonMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAwayImageButton();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("tabNo", 3);
                startActivity(intent);

            }
        });

    }

    private void goAwayImageButton() {
        YoYo.with(Techniques.SlideOutRight)
                .duration(500)
                .repeat(0)
                .playOn(buttonHighlight);

        YoYo.with(Techniques.SlideOutRight)
                .duration(500)
                .repeat(0)
                .playOn(buttonScience);
        YoYo.with(Techniques.SlideOutRight)
                .duration(500)
                .repeat(0)
                .playOn(buttonGaming);

        YoYo.with(Techniques.SlideOutRight)
                .duration(500)
                .repeat(0)
                .playOn(buttonMovies);
    }
}