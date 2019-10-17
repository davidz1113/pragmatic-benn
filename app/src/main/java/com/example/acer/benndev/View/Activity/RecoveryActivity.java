package com.example.acer.benndev.View.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.acer.benndev.Interactor.RecoveryInteractor;
import com.example.acer.benndev.R;
import com.example.acer.benndev.View.Fragment.EnterEmailFragment;
import com.example.acer.benndev.View.Fragment.EnterIdFragment;

public class RecoveryActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentEnterEmail;
    Fragment fragmentEnterId;

    RecoveryInteractor recoveryInteractor;

    TextView tvTextTitle;

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

        //iniciacion de el interactor con su respectivo constructor.
        recoveryInteractor = new RecoveryInteractor(this);

        transaction = getSupportFragmentManager().beginTransaction();
        //fragmentEnterEmail.setRetainInstance(true);
        transaction.add(R.id.framelayout_enter_email, fragmentEnterEmail).commit();

        /**
         * variables de xml
         */

        tvTextTitle = findViewById(R.id.id_tv_act_recovery_title);


    }

    public void nextStep(View v){
        if(!fragmentEnterId.isAdded()){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragmentEnterEmail);
            transaction.add(R.id.framelayout_enter_email, fragmentEnterId)
                    .addToBackStack(null).commit();
            setTitleText("Corrobore su identificación");

        }
    }

    /**
     * metodo que permite regresar entre fragmentos
     * @param v
     */
    public void goBack(View v){
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            //System.out.println(fragmentEnterEmail.isHidden());
            //getSupportFragmentManager().beginTransaction().hide(fragmentEnterId).show(fragmentEnterEmail).commit();
            getSupportFragmentManager().popBackStack();
            setTitleText("Ingrese su correo"); //se asume qué al regresar del fragmento de corroborar, volvera al de ingresar correo.
        }else{ //si en la pila de fragmentos no hay mas, se regresa a la actividad.
            super.onBackPressed();
        }
    }

    /**
     * metodo para configurar el titulo principal superior
     * @param title nuevo titulo cadena de texto
     */
    public void setTitleText(String title){
        this.tvTextTitle.setText(title);
    }


    @Override
    public void onBackPressed() {
        this.goBack(null);
    }
}
