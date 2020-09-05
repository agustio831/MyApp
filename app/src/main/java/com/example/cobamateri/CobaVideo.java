package com.example.cobamateri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class CobaVideo extends AppCompatActivity {

    private Button mNextBtn2;
    private Button mBackBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba_video2);

        mBackBtn2 = (Button) findViewById(R.id.backBtn2);
        mNextBtn2 = (Button) findViewById(R.id.nextBtn2);

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        mNextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivityKuis();
            }
        });

        mBackBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void OpenActivityKuis() {
        Intent intent = new Intent(this, CobaKuis.class);
        startActivity(intent);
        super.finish();
    }

}