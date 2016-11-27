package com.example.sayla.messageapp;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    Button btn;

    String data;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);


        final AlertDialog.Builder alert;
        intent=new Intent(getApplicationContext(),MainActivity.class);

        txt = (EditText) findViewById(R.id.editText1);

        btn = (Button) findViewById(R.id.btn);

        alert = new AlertDialog.Builder(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   data = txt.getText().toString();

                   PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);


                   SmsManager sms = SmsManager.getDefault();
                   sms.sendTextMessage("03462597420", null, data, pi, null);
               }catch (Exception e){
                   //Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                     alert.setMessage(""+e);

                   Log.d("E" ,e.toString()  );
               }
            }
        });


    }
}
