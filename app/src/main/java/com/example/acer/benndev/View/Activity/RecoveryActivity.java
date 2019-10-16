package com.example.acer.benndev.View.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.acer.benndev.R;
import com.example.acer.benndev.View.Fragment.EnterEmailFragment;
import com.example.acer.benndev.View.Fragment.EnterIdFragment;

public class RecoveryActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentEnterEmail;
    Fragment fragmentEnterId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
        /**
         * inicializacion de las variables
         */
        fragmentEnterEmail = new EnterEmailFragment();
        fragmentEnterId = new EnterIdFragment();

        System.out.println(fragmentEnterId.isAdded());

        transaction = getSupportFragmentManager().beginTransaction();
        //fragmentEnterEmail.setRetainInstance(true);
        transaction.add(R.id.framelayout_enter_email, fragmentEnterEmail).commit();
    }

    public void nextStep(View v){
        if(!fragmentEnterId.isAdded()){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragmentEnterEmail);
            transaction.add(R.id.framelayout_enter_email, fragmentEnterId)
                    .addToBackStack(null).commit();
        }
    }

    public void goBack(View v){
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            //System.out.println(fragmentEnterEmail.isHidden());
            //getSupportFragmentManager().beginTransaction().hide(fragmentEnterId).show(fragmentEnterEmail).commit();
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
