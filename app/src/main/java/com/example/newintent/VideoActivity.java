package com.example.newintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    final int REQUEST_VIDEO_CAPTURE =100;
    Button btn1;
    VideoView VideoV;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        btn1=(Button) findViewById(R.id.btnFilmer);
        VideoV = (VideoView) findViewById(R.id.videoV);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itt = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
               resultLauncher.launch(itt);
            }
        });

    }
ActivityResultLauncher<Intent> resultLauncher
        =registerForActivityResult
            (
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                uri = result.getData().getData();

                VideoV.setVideoURI(uri);
                VideoV.start();  // pour démarrer directement
                // pour créer et associer au lecteur vidéo un contrôleur
                //le contexte activité est obligatoire
                MediaController mediaController = new MediaController(VideoActivity.this);
                mediaController.show();
                VideoV.setMediaController(mediaController);
            }
        }
    }
        );



}