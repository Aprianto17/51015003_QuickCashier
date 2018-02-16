package com.example.aprianto.quickcashier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class BayarActivity extends AppCompatActivity implements ViewInterface  {

    public TextView tvTtl ;
    Nota nota;
    String ttl;

    Integer u1 = 0 ;
    Integer u2 = 0 ;
    Integer u3 = 0 ;
    Integer u4 = 0 ;
    Integer u5 = 0 ;
    Integer u6 = 0 ;
    Integer u7 = 0 ;
    Integer u8 = 0 ;
    Integer u9 = 0 ;
    Integer u10 = 0 ;

    Intent i;

    Locale localeID = new Locale("in", "ID");
    NumberFormat format = NumberFormat.getNumberInstance(localeID);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        nota = getIntent().getParcelableExtra("nota");

        tvTtl = (TextView) findViewById(R.id.tvTtl);
//        tvTtl.setText(format.format(0));
        tvTtl.setText(nota.getTotalHarga() + "");

        Log.e(nota.getTotalHarga().toString(),"Ttl");

    }

    public void bt1 (View view) {//perintah tombol tambah
        u1 = u1 + 1;
        play(u1);
    }

    public void bt2 (View view) {//perintah tombol tambah
        u2 = u2 + 1;
        play(u2);
    }

    public void bt3 (View view) {//perintah tombol tambah
        u3 = u3 + 1;
        play(u3);
    }

    public void bt4 (View view) {//perintah tombol tambah
        u4 = u4 + 1;
        play(u4);
    }

    public void bt5 (View view) {//perintah tombol tambah
        u5 = u5 + 1;
        play(u5);
    }

    public void bt6 (View view) {//perintah tombol tambah
        u6 = u6 + 1;
        play(u6);
    }

    public void bt7 (View view) {//perintah tombol tambah
        u7 = u7 + 1;
        play(u7);
    }

    public void bt8 (View view) {//perintah tombol tambah
        u8 = u8 + 1;
        play(u8);
    }

    public void bt9 (View view) {//perintah tombol tambah
        u9 = u9 + 1;
        play(u9);
    }

    public void bt10 (View view) {//perintah tombol tambah
        u10 = u10 + 1;
        play(u10);
    }

    public void play(Integer number) {

        TextView tvBayar = (TextView) findViewById(R.id.tb0);
        tvBayar.setText(format.format(""+ (u1*100000+u2*50000+u3*20000+u4*10000+u5*5000+u6*2000+u7*1000+u8*500+u9*200+u10*100)));
        Log.e(""+ (u1*100000+u2*50000+u3*20000+u4*10000+u5*5000+u6*2000+u7*1000+u8*500+u9*200+u10*100),"Ttl");
    }

    @Override
    public void updateNota(Menu menu, int increment) {
        tvTtl.setText(format.format(nota.getTotalHarga()));
        Log.e(nota.getTotalHarga().toString(),"Ttl");
    }
}

