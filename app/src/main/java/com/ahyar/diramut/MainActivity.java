package com.ahyar.diramut;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private beranda beranda = new beranda();
    private bantuan bantuan= new bantuan();
    private diagnosa diagnosa = new diagnosa();
    private tentang tentang = new tentang();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.beranda);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.beranda:
                getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, beranda).commit();
                return true;
            case R.id.diagnosa:
                getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, diagnosa).commit();
                return true;
            case R.id.daftarpenyakit:
                Intent intent = new Intent(this,dftpenyakit.class);
                startActivity(intent);
                return true;
            case R.id.bantuan:
                getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, bantuan).commit();
                return true;
            case R.id.tentang:
                getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, tentang).commit();
                return true;


        }
        return false;

    }
}

