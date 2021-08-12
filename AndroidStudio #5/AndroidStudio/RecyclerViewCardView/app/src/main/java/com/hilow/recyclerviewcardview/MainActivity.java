package com.hilow.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        isiData();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Jeje", "Bandung"));
        siswaList.add(new Siswa("Febri", "Yogyakarta"));
        siswaList.add(new Siswa("Setya", "Semarang"));
        siswaList.add(new Siswa("Kiky", "Bogor"));
        siswaList.add(new Siswa("Ciko", "Kediri"));
        siswaList.add(new Siswa("Bella", "Malang"));
        siswaList.add(new Siswa("Yogi", "Surabaya"));
        siswaList.add(new Siswa("Tya", "Cirebon"));
        siswaList.add(new Siswa("Lisa", "Madiun"));
        siswaList.add(new Siswa("Reyna", "Sidoarjo"));
        siswaList.add(new Siswa("Cici", "Solo"));
        siswaList.add(new Siswa("Reynald", "Bandung"));

        adapter = new SiswaAdapter(this, siswaList);
        recyclerView.setAdapter(adapter);
    }


    public void btnTambah(View view) {
        siswaList.add(new Siswa("Rio Waida", "Uluwatu, Bali"));

        adapter.notifyDataSetChanged();
    }
}