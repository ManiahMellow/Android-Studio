package com.hilow.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etnilai;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();

    }

    public void load(){
        spinner = findViewById(R.id.spinner);
        etnilai = findViewById(R.id.etNilai);
        tvhasil = findViewById(R.id.tvHasil);
    }

    /*
        public void isiSpinner(){
            String[] isi = {"Celcius to Reamour", "Celcious to Fahrenheit", "Celcius to Kelvin"};

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, isi);
            spinner.setAdapter(adapter);
        }

     */

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();
        
        if (etnilai.getText().toString().equals("")){
            Toast.makeText(this, "Nilai Wajib Diisi!", Toast.LENGTH_SHORT).show();
        }else{
            if (pilihan.equals("Celcius to Reamour")){
                cToR();
            }

            if (pilihan.equals("Celcius to Fahrenheit")){
                cToF();
            }

            if (pilihan.equals("Celcius to Kelvin")){
                cToK();
            }

            if (pilihan.equals("Reamour to Celcius")){
                rToC();
            }

            if (pilihan.equals("Reamour to Fahrenheit")){
                rToF();
            }

            if (pilihan.equals("Reamour to Kelvin")){
                rToK();
            }

            if (pilihan.equals("Kelvin to Celcius")){
                kToC();
            }

            if (pilihan.equals("Kelvin to Reamour")){
                kToR();
            }

            if (pilihan.equals("Kelvin to Fahrenheit")){
                kToF();
            }


            if(pilihan.equals("Fahrenheit to Celcius")){
                fToC();
            }

            if(pilihan.equals("Fahrenheit to Reamour")){
                fToR();
            }

            if(pilihan.equals("Fahrenheit to Kelvin")){
                fToK();
            }

        }

    }

    public void cToR(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;

        tvhasil.setText(hasil+"");
    }

    public void cToF(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (9.0/5.0) * suhu + 32;

        tvhasil.setText(hasil+"");
    }

    public void cToK(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = suhu + 273;

        tvhasil.setText(hasil+"");
    }

    public void rToC(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (5.0/4.0) * suhu;

        tvhasil.setText(hasil+"");
    }

    public void rToF(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (9.0/4.0) * suhu + 32;

        tvhasil.setText(hasil+"");
    }

    public void rToK(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (5.0/4.0) * suhu + 273;

        tvhasil.setText(hasil+"");
    }

    public void kToC(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = suhu - 273;

        tvhasil.setText(hasil+"");
    }

    public void kToR(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (4.0/5.0) * (suhu - 273);

        tvhasil.setText(hasil+"");
    }

    public void kToF(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (9.0/5.0) * (suhu - 273) +32;

        tvhasil.setText(hasil+"");
    }

    public void fToC(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (5.0/9.0) * (suhu - 32);

        tvhasil.setText(hasil+"");
    }

    public void fToR(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (4.0/9.0) * (suhu - 32);

        tvhasil.setText(hasil+"");
    }

    public void fToK(){
        double suhu = Double.parseDouble(etnilai.getText().toString());
        double hasil = (5.0/9.0) * (suhu - 32) + 273;

        tvhasil.setText(hasil+"");
    }

}