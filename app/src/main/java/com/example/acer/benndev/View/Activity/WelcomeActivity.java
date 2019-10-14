package com.example.acer.benndev.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.acer.benndev.R;
import com.example.acer.benndev.View.Fragment.WelcomeStep1Fragment;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Fragment fragment = new WelcomeStep1Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_welcome_step1, new WelcomeStep1Fragment()).commit();
    }
}
