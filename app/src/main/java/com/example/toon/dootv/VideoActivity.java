package com.example.toon.dootv;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URL;

public class VideoActivity extends AppCompatActivity {

    private String urlStream;
    private VideoView myVideoView;
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra("title"));

        VideoView videoView = (VideoView) findViewById(R.id.VideoPlayer);
        String httpLiveUrl = intent.getStringExtra("source");
        videoView.setVideoURI(Uri.parse(httpLiveUrl));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();

    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (getActionBar() != null) {
                getActionBar().hide();
            }
        } else {
            if (getActionBar() != null) {
                getActionBar().hide();
            }
        }
    }

}
