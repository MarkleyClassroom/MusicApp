package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnRewind, btnPlay, btnPause;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add the on click listeners
        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(playMusic);

        btnPause = findViewById(R.id.btnPause);
        btnPause.setOnClickListener(playMusic);

        btnRewind = findViewById(R.id.btnRewind);
        btnRewind.setOnClickListener(playMusic);
    }

    View.OnClickListener playMusic = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnPlay:
                    if(mediaPlayer == null)
                    {
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.hawaii50);
                    }
                    mediaPlayer.start();
                    break;
                case R.id.btnPause:
                    if (mediaPlayer != null){
                        mediaPlayer.pause();
                    }
                    Toast.makeText(MainActivity.this, "Pausing", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnRewind:
                    if (mediaPlayer != null) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                        Toast.makeText(MainActivity.this, "Rewinding", Toast.LENGTH_LONG).show();
                    }
                    break;

            }

        }
    };
}