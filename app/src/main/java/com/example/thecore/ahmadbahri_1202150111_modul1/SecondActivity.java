package com.example.thecore.ahmadbahri_1202150111_modul1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Context context	=	getApplicationContext();

        Toast ya =	Toast.makeText(context,	"Langsung Terbang ke Lokasi",	Toast.LENGTH_LONG);
        Toast tidak = Toast.makeText(context, "Angkringan aja lah ya", Toast.LENGTH_LONG);
        TextView menuView = (TextView) findViewById(R.id.hasilMenu);
        TextView hargaView = (TextView) findViewById(R.id.hasilHarga);
        TextView jumlahView = (TextView) findViewById(R.id.hasilPorsi);
        TextView tempatView = (TextView) findViewById(R.id.hasilTempat);

        Intent intent = getIntent();
        int totalInt = intent.getIntExtra("totalHarga", 0);
        String total = Integer.toString(totalInt);

        int jumlahInt = intent.getIntExtra("portion", 0);
        String porsi = Integer.toString(jumlahInt);

        String menu = intent.getStringExtra("menu");

        int uangInt = intent.getIntExtra("uang", 0);

        String lokasi = intent.getStringExtra("lokasi");

        menuView.setText(menu);
        hargaView.setText(total);
        jumlahView.setText(porsi);


        if (uangInt >= totalInt){
            ya.show();
            tempatView.setText(lokasi);

        }else{
            tidak.show();
            tempatView.setText(lokasi);
        }
    }
}
