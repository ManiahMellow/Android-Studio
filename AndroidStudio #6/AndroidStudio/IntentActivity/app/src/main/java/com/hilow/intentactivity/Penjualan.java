package com.hilow.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Penjualan extends AppCompatActivity {

    TextView tvjual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);

        load();
        tampil();
    }

    public void load(){
        tvjual = findViewById(R.id.tvJual);
    }

    public void tampil(){
        String hasil = ("INI PENJUALAN!");

        tvjual.setText(hasil);
    }
}