package com.hilow.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Pembelian extends AppCompatActivity {

    TextView tvbeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);

        load();
        hasil();
    }

    public void load(){
        tvbeli = findViewById(R.id.tvBeli);
    }

    public void hasil(){
        String tampil = ("INI PEMBELIAN!");

        tvbeli.setText(tampil);
    }
}