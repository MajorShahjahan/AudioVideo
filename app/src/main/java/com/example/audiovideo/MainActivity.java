package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView myVideoView;
    private Button btnPlayVideo;
    private Button btnPlayMusic;
    private Button btnPauseMusic;
    private MediaController mediaController;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.myVideoView);
        btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnPlayMusic = findViewById(R.id.btnPlayMusic);
        btnPauseMusic = findViewById(R.id.btnPauseMusic);
        mediaController = new MediaController(MainActivity.this);
        mediaPlayer = MediaPlayer.create(this,R.raw.rain);

        btnPlayVideo.setOnClickListener(MainActivity.this);
        btnPlayMusic.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()){

            case R.id.btnPlayVideo:

                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bokehvideo);
                myVideoView.setVideoURI(videoUri);
                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView);
                myVideoView.start();

                break;

            case R.id.btnPlayMusic:

                mediaPlayer.start();

                break;

            case R.id.btnPauseMusic:

                mediaPlayer.pause();

                break;
        }


    }
}