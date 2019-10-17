package com.example.acer.benndev.Interactor;

import com.example.acer.benndev.View.Fragment.WelcomeStep1Fragment;

public class WelcomeStep1Interactor {

    WelcomeStep1Fragment welcomeStep1Fragment;

    public WelcomeStep1Interactor(WelcomeStep1Fragment welcomeStep1Fragment) {
        this.welcomeStep1Fragment = welcomeStep1Fragment;
    }

    public void onTextChange(String text){
        boolean actionNumber=false;
        boolean actionSpecial=false;
        boolean actionUpper=false;
        //longitud minima de 8
        if(minLength(text)){
            welcomeStep1Fragment.paintCheckboxMin(true);
        }else {
            welcomeStep1Fragment.paintCheckboxMin(false);
        }
        //recorre la la palabra letra por letra
        for (int i=0;i<text.length();i++){
            //si es un numero
            if(isNumber(text.charAt(i))){
                actionNumber=true;
            }
            //si es un caracter especial
            if(isSpecialCharacter(text.charAt(i))){
                actionSpecial=true;
            }
            //si es una mayuscula
            if(isUpperCase(text.charAt(i))){
                actionUpper=true;
            }
        }
        //habilita o deshabilita lo checkbox
        welcomeStep1Fragment.paintCheckboxNum(actionNumber);
        welcomeStep1Fragment.paintCheckboxSpe(actionSpecial);
        welcomeStep1Fragment.paintCheckboxUpp(actionUpper);
    }

    public boolean minLength(String text){
        if(text.length()>=8){
            return true;
        }else {
            return false;
        }
    }
    public boolean isNumber(char letter){
        int ascii=(int)letter;
        /*0 -9 = 48 -57*/
       if(ascii>=48 && ascii<=57){
           return true;
       }else{
           return false;
       }
    }
    public boolean isSpecialCharacter(char letter){
        /*si no es */
        if(!isNumber(letter) && !isLetter(letter) && !isUpperCase(letter)){
            return true;
        }else {
            return false;
        }

    }
    public boolean isLetter(char letter){
        /*a - z = 67 -112*/
        int ascii=(int)letter;
        if((ascii>=97 && ascii<=122) || ascii==165){
            return true;
        }else{
            return false;
        }
    }
    public boolean isUpperCase(char letter){
        /* A - Z = 65 - 90*/
        int ascii=(int)letter;
        if(ascii>=65 && ascii<=90){
            return true;
        }else{
            return false;
        }
    }
}

