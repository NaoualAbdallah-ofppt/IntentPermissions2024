package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {
    Button btnEnvoyer;
    EditText txtNum, txtBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);
        btnEnvoyer=(Button) findViewById(R.id.btnEnvoyer) ;
        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum = (EditText) findViewById(R.id.txtNum);
                txtBody = (EditText) findViewById(R.id.txtBody);
        /*
        //préparation à l'envoi
                Uri U = Uri.parse("smsto:" + txtNum.getText().toString());

                Intent it = new Intent(Intent.ACTION_SENDTO, U);
                it.putExtra("sms_body", txtBody.getText().toString());
                startActivity(it);

         */

//C'est un envoi. L'autorisation doit être activée
                //   En utilisant SmsManager l'envoi est effectué
                try {
                    SmsManager.getDefault().sendTextMessage(txtNum.getText().toString(),
                            null,txtBody.getText().toString() , null,null);
                   Toast.makeText(getApplicationContext(), "SMS envoyé!", Toast.LENGTH_LONG).show();
                }
                catch (Exception e) {

                    Toast.makeText(getApplicationContext(),"Echec de l'envoi. Réessayez plus tard!",Toast.LENGTH_LONG).show();
                    // e.printStackTrace();
                }




            }
            });

    }
}