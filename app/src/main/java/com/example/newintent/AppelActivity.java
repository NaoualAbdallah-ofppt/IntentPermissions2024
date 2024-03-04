package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppelActivity extends AppCompatActivity {
    Button btnAppeler;
    EditText txtNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel);
        btnAppeler=findViewById(R.id.btnAppeler);
        txtNum=findViewById(R.id.txtNum);
        btnAppeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri =Uri.parse("tel:" + txtNum.getText().toString());
               // Intent it = new Intent(Intent.ACTION_DIAL , U);
               Intent it = new Intent(Intent.ACTION_CALL , uri) ;

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AppelActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
// A voir plus tard
                    // exploitation de la réponse suite à l'affichage de la boite de dialogue
                    }





                startActivity(it); ;

            }
        });
    }
}