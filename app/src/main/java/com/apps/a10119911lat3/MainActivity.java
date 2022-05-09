package com.apps.a10119911lat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/*
Developed by MochamadTegar
on Sunday, May 8 2022
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnStart);
        button.setOnClickListener(v -> next());
    }
    public void next(){
        Intent intent = new Intent(MainActivity.this, LoginCode.class);
        startActivity(intent);
    }

}