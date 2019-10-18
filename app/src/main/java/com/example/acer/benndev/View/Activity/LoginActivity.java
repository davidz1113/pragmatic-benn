package com.example.acer.benndev.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.acer.benndev.Interactor.LoginInteractor;
import com.example.acer.benndev.R;


public class LoginActivity extends AppCompatActivity {

    TextView txtloggin1;
    LoginInteractor loginInteractor;
    Button buttonSingin;
    RelativeLayout rlNotifyUser;

    private final static int REQUEST_CODE_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginInteractor = new LoginInteractor(this);

        /*INICIALIZACION DE COMPONENTES DE LA VISTA*/
        initComponentsView();

        buttonSingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSingIn(view);
            }
        });

        String textLogin = txtloggin1.getText().toString();
        SpannableString textSpann = new SpannableString(textLogin);

        final int colorAccent = ContextCompat.getColor(this, R.color.colorAccent);


        ClickableSpan clickPoliticsPrivacity = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(colorAccent);

            }
        };
        ClickableSpan clickTermsAndConditions = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(colorAccent);
            }
        };


        //Al utilizar la aplicación usted acepta nuestra Política de Privacidad, así como los Términos y Condiciones
        textSpann.setSpan(clickPoliticsPrivacity, 47, 69, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textSpann.setSpan(clickTermsAndConditions, 84, 106, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtloggin1.setText(textSpann);
        txtloggin1.setMovementMethod(LinkMovementMethod.getInstance());


        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }


    public void initComponentsView() {
        txtloggin1 = findViewById(R.id.id_tv_logintext1);
        buttonSingin = findViewById(R.id.id_log_btn_singin);
        rlNotifyUser = findViewById(R.id.id_rl_act_login_notify);

    }


    public void onClickSingIn(View v) {
        Intent intent = new Intent(v.getContext(), WelcomeActivity.class);
        startActivityForResult(intent, 0);
    }


    public void goToRecover(View v) {
        Intent intent = new Intent(this, RecoveryActivity.class);
        startActivityForResult(intent, REQUEST_CODE_1);
    }


    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * metodo que oculta el panel de notificacion cuando llega desde el recuperar contraseña
     *
     * @param view
     */
    public void setVisibility(View view) {
        rlNotifyUser.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case REQUEST_CODE_1:
                if (data != null) {//se valida que vengan datos desde la actividad del registro
                    String stringExtra = data.getStringExtra("show_notify");
                    System.out.println(stringExtra);
                    rlNotifyUser.setVisibility(View.VISIBLE);
                    //se debe cambiar el texto de la notificacion con el correo que ha diligenciado en el fragmento de correo.
                }
                break;
        }
    }
}
