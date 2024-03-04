package com.example.newintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
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

public class PhotoActivity extends AppCompatActivity {
    Button btn1;
    Uri imgUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        btn1 = (Button) findViewById(R.id.btnPhotographier);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                resultLaucher.launch(itt);
            }
        });
    }
    ActivityResultLauncher<Intent> resultLaucher
            =registerForActivityResult
            (
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    ImageView img= (ImageView) findViewById(R.id.img);

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Bundle extras =result.getData().getExtras();
                        Bitmap BmpImg = (Bitmap) extras.get("data");
                        img.setImageBitmap(BmpImg);

                       /*
                       à voir
                       Uri u=result.getData().getData();
                       img.setImageURI(u);

                        */

                          }
                }
            }
        );

}