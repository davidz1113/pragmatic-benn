package com.example.acer.benndev.Interactor;

import com.example.acer.benndev.Repository.LoginRepository;
import com.example.acer.benndev.View.Activity.LoginActivity;

public class LoginInteractor {
    LoginActivity loginActivity;
    LoginRepository loginRepository;

    public LoginInteractor(LoginActivity login) {
        this.loginActivity= login;
        loginRepository=new LoginRepository(this);
    }

}
