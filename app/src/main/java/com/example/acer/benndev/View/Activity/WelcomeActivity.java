package com.example.acer.benndev.View.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.acer.benndev.R;
import com.example.acer.benndev.View.Fragment.WelcomeStep1Fragment;
import com.example.acer.benndev.View.Fragment.WelcomeStep2Fragment;

public class WelcomeActivity extends AppCompatActivity {

    Fragment fragmentStep1,fragmentStep2;
    Button buttonContinue,buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /*INICIALIZACION COMOPNENTES DE VISTA*/
        initComponentsView();

        this.fragmentStep1=new WelcomeStep1Fragment();
        this.fragmentStep2=new WelcomeStep2Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_welcome_step,fragmentStep1).commit();
    }

    public void initComponentsView(){
        buttonContinue=findViewById(R.id.id_wel_btn_continue);
        buttonBack=findViewById(R.id.id_wel_btn_back);
    }
    public void onClickContinue(View v){

        if(!fragmentStep2.isAdded()){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragmentStep1);
            transaction.add(R.id.framelayout_welcome_step, fragmentStep2)
                    .addToBackStack(null).commit();
        }else{
            Intent intent = new Intent (v.getContext(), LoginActivity.class);
            startActivityForResult(intent, 0);
        }

    }
    public void onClickBack(View v){
        if(!fragmentStep1.isVisible()){
            if(getSupportFragmentManager().getBackStackEntryCount()>0){
                getSupportFragmentManager().popBackStack();
            }else{
                super.onBackPressed();
            }
        }else{
            Intent intent = new Intent (v.getContext(), LoginActivity.class);
            startActivityForResult(intent, 0);
        }
    }


}
