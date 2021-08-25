package com.hilow.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etbarang, etstok;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        etbarang = findViewById(R.id.etBarang);
        etstok = findViewById(R.id.etStok);

        sharedPreferences = getSharedPreferences("barang", MODE_PRIVATE);
    }

    public void isiSharedPreferences(String barang, Float stok){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("barang", barang);
        editor.putFloat("stok", stok);

        editor.apply();
    }

    public void simpan(View view) {
        String barang = etbarang.getText().toString();
        Float stok = Float.parseFloat(etstok.getText().toString());

        if (barang.isEmpty() || stok == 0.0){
            Toast.makeText(this, "Data kosong", Toast.LENGTH_SHORT).show();
        }else {
            isiSharedPreferences(barang, stok);
            Toast.makeText(this, "Data sudah disimpan", Toast.LENGTH_SHORT).show();
        }

        etbarang.setText("");
        etstok.setText("");
    }

    public void tampil(View view) {
        String barang = sharedPreferences.getString("barang", "");
        Float stok = sharedPreferences.getFloat("stok", 0);

        etbarang.setText(barang);
        etstok.setText(stok + "");
    }
}