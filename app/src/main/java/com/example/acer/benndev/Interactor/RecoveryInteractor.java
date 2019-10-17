package com.example.acer.benndev.Interactor;

import com.example.acer.benndev.View.Activity.RecoveryActivity;
import com.example.acer.benndev.View.Fragment.EnterEmailFragment;
import com.example.acer.benndev.View.Fragment.EnterIdFragment;

/**
 * Created by ANDRES on 17/10/2019.
 */

public class RecoveryInteractor {

    RecoveryActivity recoveryActivity;
    EnterEmailFragment enterEmailFragment;
    EnterIdFragment enterIdFragment;

    public RecoveryInteractor(RecoveryActivity recoveryActivity) {
        this.recoveryActivity = recoveryActivity;
    }

    public RecoveryInteractor(EnterEmailFragment enterEmailFragment) {
        this.enterEmailFragment = enterEmailFragment;
    }

    public RecoveryInteractor(EnterIdFragment enterIdFragment) {
        this.enterIdFragment = enterIdFragment;
    }

}


