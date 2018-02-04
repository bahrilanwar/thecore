package com.example.thecore.ahmadbahri_1202150111_modul1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    private int hargaUpnormal = 30000;
    private int hargaEatbus = 50000;
    public int uang = 65500;
    private int totalHarga;
    private EditText aMenu;
    private EditText aTotal;
    public TextView duit;
    String adaMenu = "Nasi Uduk";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aMenu = (EditText) findViewById(R.id.menu);
        aTotal = (EditText) findViewById(R.id.jumlah);
        duit = (TextView) findViewById(R.id.saldo);
        duit.setText(uang);

    }

    public void clickEatbus(View view) {
        Log.d(LOG_TAG, "Button Eatbus");
        Context context = getApplicationContext();
        Toast noMenu = Toast.makeText(context, "Pilih Menu lain", Toast.LENGTH_LONG);
        Toast noTotal = Toast.makeText(context, "Hanya bisa couple", Toast.LENGTH_LONG);
        int jumlah = Integer.parseInt(aTotal.getText().toString());
        String menu = aMenu.getText().toString();
        totalHarga = jumlah * hargaEatbus;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("portion", jumlah);
        intent.putExtra("menu", menu);
        intent.putExtra("totalHarga", totalHarga);
        intent.putExtra("uang", uang);
        intent.putExtra("lokasi", "Eatbus");
        if (aMenu.getText().toString().equals("Nasi Uduk")) {
            if (aTotal.getText().toString().equals("2")) {
                startActivity(intent);
            } else {
                noTotal.show();
            }
        } else {
            noMenu.show();
        }
    }

    public void clickUpnormal(View view) {
        Log.d(LOG_TAG, "Button Upnormal");
        Context context = getApplicationContext();
        Toast noMenu = Toast.makeText(context, "Menu tidak ada, coba yang lain", Toast.LENGTH_LONG);
        Toast noTotal = Toast.makeText(context, "Hanya bisa makan berdua", Toast.LENGTH_LONG);
        int jumlah = Integer.parseInt(aTotal.getText().toString());
        String menu = aMenu.getText().toString();
        totalHarga = jumlah * hargaUpnormal;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("jumlah", jumlah);
        intent.putExtra("menu", menu);
        intent.putExtra("totalHarga", totalHarga);
        intent.putExtra("uang", uang);
        intent.putExtra("lokasi", "Upnormal");
        if (aMenu.getText().toString().equals("Nasi Uduk")) {
            if (aTotal.getText().toString().equals("2")) {
                startActivity(intent);
            } else {
                noTotal.show();
            }
        } else {
            noMenu.show();
        }
    }

}
