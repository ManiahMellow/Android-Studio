package com.hilow.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etbarang, etstok, etharga;
    TextView tvpilihan;

    List<Barang> databarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        selectData();
    }

    public void load(){
        db = new Database(this);

        db.buatTabel();

        etbarang = findViewById(R.id.etBarang);
        etstok = findViewById(R.id.etStok);
        etharga = findViewById(R.id.etHarga);
        tvpilihan = findViewById(R.id.tvPilihan);
        rcvbarang = findViewById(R.id.rcvBarang);

        rcvbarang.setLayoutManager(new LinearLayoutManager(this));
        rcvbarang.setHasFixedSize(true);
    }

    public void simpan(View v){
        String barang = etbarang.getText().toString();
        String stok = etstok.getText().toString();
        String harga = etharga.getText().toString();
        String pilihan = tvpilihan.getText().toString();

        if (barang.isEmpty()|| stok.isEmpty() || harga.isEmpty()){
            pesan("Data kosong, anda wajib mengisi semua kolom!");
        }else {
            if (pilihan.equals("insert")){
                String sql = "INSERT INTO tblbarang (barang, stok, harga) VALUES ('"+barang+"', "+stok+", "+harga+")";

                if(db.runSQL(sql)){
                    pesan("Insert Data Berhasil");

                    selectData();
                }else {
                    pesan("Insert Data Gagal");
                }

            }else {
                pesan("Update Data");
            }
        }

        etbarang.setText("");
        etstok.setText("");
        etharga.setText("");

        tvpilihan.setText("insert");
    }

    public void pesan(String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    public void selectData(){
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);
        databarang.clear();

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                String idbarang = cursor.getString(cursor.getColumnIndex("idBarang"));
                String barang = cursor.getString(cursor.getColumnIndex("barang"));
                String stok = cursor.getString(cursor.getColumnIndex("stok"));
                String harga = cursor.getString(cursor.getColumnIndex("harga"));

                databarang.add(new Barang(idbarang,barang,stok,harga));
            }

            adapter = new BarangAdapter(this, databarang);
            rcvbarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else{
            pesan("Data Kosong");
        }

    }

    public void deleteData(String id){
        String idBarang = id;
        String sql = "DELETE FROM tblbarang WHERE idBarang = "+idBarang+" ";

        if (db.runSQL(sql)){
            pesan("Data sudah dihapus");

            selectData();
        }else{
            pesan("Data gagal dihapus");
        }

    }


}