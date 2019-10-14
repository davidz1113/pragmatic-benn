package com.example.acer.benndev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Fragment fragment = new FragmentWelcomeStep1();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_welcome_step1, new FragmentWelcomeStep1()).commit();
    }
}
