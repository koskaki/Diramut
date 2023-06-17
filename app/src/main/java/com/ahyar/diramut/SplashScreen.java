package com.ahyar.diramut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        }

    public void lnjutbtn(View view) {
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
    }
}
