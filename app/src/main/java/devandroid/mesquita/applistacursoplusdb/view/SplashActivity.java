package devandroid.mesquita.applistacursoplusdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.mesquita.applistacursoplusdb.R;
import devandroid.mesquita.applistacursoplusdb.database.ListaVipDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ListaVipDB db = new ListaVipDB(SplashActivity.this);

        comutarTelaSplash();


    }

    private void comutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent telaPrincipal = new Intent(
                        SplashActivity.this,
                        MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },TIME_OUT_SPLASH);
    }
}