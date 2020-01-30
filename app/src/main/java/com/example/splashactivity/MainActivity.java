package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.never_give_up_2);
        mediaPlayer.start();

        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(3000);
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
    protected void onPause() {
        super.onPause();
        finish();
        mediaPlayer.stop();
    }
}
