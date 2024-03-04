package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText ENom,EPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btnEntrer);
        ENom= (EditText)findViewById(R.id.txtNom) ;
        EPrenom= (EditText)findViewById(R.id.txtPrenom) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), RecupActivity.class);
               it.putExtra("Nom",ENom.getText().toString());
                it.putExtra("Prenom",EPrenom.getText().toString());
                startActivity(it);
           /*     Bundle bd = new Bundle();
                bd.putFloat("rr", 4);

                it.putExtras(bd);
                */


            }
        });

    }
}