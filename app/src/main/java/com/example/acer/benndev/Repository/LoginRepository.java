package com.example.acer.benndev.Repository;

import com.example.acer.benndev.Interactor.LoginInteractor;

public class LoginRepository {
    LoginInteractor loginInteractor;

    public LoginRepository(LoginInteractor loginInteractor) {
        this.loginInteractor = loginInteractor;
    }
}
