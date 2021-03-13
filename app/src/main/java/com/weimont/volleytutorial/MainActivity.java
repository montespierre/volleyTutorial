package com.weimont.volleytutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Tutorial
    // https://youtu.be/4PIjHEv6Xwc

    Button vButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI.
        initUI();

        vButton.setOnClickListener((view) -> {
            startActivity(new Intent(MainActivity.this, MainActivityDos.class));
        });


    }

    private void initUI() {
        vButton = findViewById(R.id.button);
    }


}