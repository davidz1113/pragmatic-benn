package com.example.acer.benndev.View.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.acer.benndev.Interactor.WelcomeStep1Interactor;
import com.example.acer.benndev.R;


public class WelcomeStep1Fragment extends Fragment {

    EditText editTextPass,editTextCofimPass;
    WelcomeStep1Interactor welcomeStep1Interactor;
    CheckBox checkBoxNum,checkBoxMin,checkBoxUpp,checkBoxSpe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_welcome_step1, container, false);
        welcomeStep1Interactor=new WelcomeStep1Interactor(this);


        editTextPass=view.findViewById(R.id.id_wel_et_pass);
        editTextCofimPass=view.findViewById(R.id.id_wel_et_cofirmpass);
        checkBoxMin=view.findViewById(R.id.id_wel_cb_min);
        checkBoxNum=view.findViewById(R.id.id_wel_cb_num);
        checkBoxUpp=view.findViewById(R.id.id_wel_cb_upp);
        checkBoxSpe=view.findViewById(R.id.id_wel_cb_spe);


        editTextPass.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String newText=editable.toString();
                onLetterChange(newText);
            }
        });

        return view;
    }

    public void onLetterChange(String newText){
        if(newText.length()>4){
            welcomeStep1Interactor.onTextChange(newText);
        }else {

        }

    }
    public void paintCheckboxMin(boolean action){
        checkBoxMin.setChecked(action);
    }
    public void paintCheckboxUpp(boolean action){
        checkBoxUpp.setChecked(action);
    }
    public void paintCheckboxNum(boolean action){
        checkBoxNum.setChecked(action);
    }
    public void paintCheckboxSpe(boolean action){
        checkBoxSpe.setChecked(action);
    }

}
