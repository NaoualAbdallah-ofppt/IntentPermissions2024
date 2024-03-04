package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecupActivity extends AppCompatActivity {
    TextView txtNP;
    Button btn1,btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recup);
        txtNP=(TextView)findViewById(R.id.lblNP) ;
       Intent it = getIntent();
        String NP= it.getStringExtra("Nom") + " " + it.getStringExtra("Prenom") ;
       txtNP.setText("Bonjour " + NP);
        btn1=(Button)findViewById(R.id.btn1);//telephone appel
        btn2=(Button)findViewById(R.id.btn2);// Envoyer SMS
        btn3=(Button)findViewById(R.id.btn3); // Prendre photo
        btn4=(Button)findViewById(R.id.btn4);//Filmer Vidéo

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent it= new Intent(getApplicationContext(),AppelActivity.class);
                startActivity(it);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),SMSActivity.class);
                startActivity(it);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),PhotoActivity.class);
                startActivity(it);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),VideoActivity.class);
                startActivity(it);
            }
        });

    }
}