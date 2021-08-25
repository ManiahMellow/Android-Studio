package com.hilow.messagedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }
    
    public void btnToast(View view) {
        showToast("Ayo semangat belajar!");
    }

    public void showAlert(String tampil){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);

        buatAlert.setTitle("PERHATIAN!");
        buatAlert.setMessage(tampil);

        buatAlert.show();
    }

    public void btnAlert(View view) {
        showAlert("Silahkan Dipelajari");
    }

    public void showAlertButton(String nilai){
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);

        showAlert.setTitle("BELAJAR ANDROID");
        showAlert.setMessage(nilai);
        showAlert.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data sudah dimasukkan");
            }
        });
        showAlert.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data tidak disimpan");
            }
        });

        showAlert.show();
    }

    public void btnAlertDialogButton(View view) {
        showAlertButton("Yakin akan menambahkan?");
    }
}