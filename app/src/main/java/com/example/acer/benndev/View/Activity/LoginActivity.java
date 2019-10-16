package com.example.acer.benndev.View.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.acer.benndev.Interactor.LoginInteractor;
import com.example.acer.benndev.R;


public class LoginActivity extends AppCompatActivity {

    LoginInteractor loginInteractor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginInteractor = new LoginInteractor(this);
        TextView txtloggin1 = findViewById(R.id.id_tv_logintext1);
        String textLogin = txtloggin1.getText().toString();
        SpannableString textSpann = new SpannableString(textLogin);
        ClickableSpan clickPoliticsPrivacity = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };
        ClickableSpan clickTermsAndConditions = new ClickableSpan() {
            @Override
            public void onClick( View widget) {
                Intent intent = new Intent(widget.getContext(),RecoveryActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };
        //Al crear la cuenta se acepta nuestra Política de Privacidad, así como los Términos y Condiciones
        textSpann.setSpan(clickPoliticsPrivacity,37,59, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textSpann.setSpan(clickTermsAndConditions,74,96, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        txtloggin1.setText(textSpann);
        txtloggin1.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
