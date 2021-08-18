package com.hilow.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        etbarang = findViewById(R.id.etBarang);
    }

    public void btnBarang(View view) {

        String barang = etbarang.getText().toString();
        Intent intent = new Intent(this, Barang.class);

        intent.putExtra("ISI", barang);

        startActivity(intent);
    }

    public void btnJual(View view) {

        Intent hasil = new Intent(this, Penjualan.class);

        startActivity(hasil);
    }

    public void btnBeli(View view) {

        Intent tampil = new Intent(this, Pembelian.class);

        startActivity(tampil);

    }
}