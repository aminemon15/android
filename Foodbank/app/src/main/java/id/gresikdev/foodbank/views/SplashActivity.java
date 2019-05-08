package id.gresikdev.foodbank.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import id.gresikdev.foodbank.R;

public class SplashActivity extends AppCompatActivity {

    private  void pergikeWelcome(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
            }
        };
        Timer timer = new Timer("Pindah Halaman");
        timer.schedule(task, 3000);
    }
}
