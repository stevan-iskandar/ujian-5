package com.bootcamp.ujian5.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bootcamp.ujian5.R;
import com.bootcamp.ujian5.model.Data;

public class AddDataActivity extends AppCompatActivity {
  EditText inpNama, inpUmur, inpBeratBadan, inpTekananDarah, inpAlamat;
  Button btnCekBPM, btnGPS, btnSimpanData;
//  GeoLocator geoLocator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    geoLocator = new GeoLocator(getApplicationContext(), AddDataActivity.this);
    setContentView(R.layout.activity_add_data);
    setTitle("Add Data");

    inpNama = (EditText) findViewById(R.id.inpNama);
    inpUmur = (EditText) findViewById(R.id.inpUmur);
    inpBeratBadan = (EditText) findViewById(R.id.inpBeratBadan);
    inpTekananDarah = (EditText) findViewById(R.id.inpTekananDarah);
    inpAlamat = (EditText) findViewById(R.id.inpAlamat);

    btnCekBPM = (Button) findViewById(R.id.btnCekBPM);
    btnGPS = (Button) findViewById(R.id.btnGPS);
    btnGPS.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
//        String text = geoLocator.getLattitude() + "," + geoLocator.getLongitude() + "\n" + geoLocator.getAddress();
//        Toast.makeText(AddDataActivity.this, text, Toast.LENGTH_LONG).show();
      }
    });

    btnSimpanData = (Button) findViewById(R.id.btnSimpanData);
    btnSimpanData.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Data data = new Data();

        data.setNama(inpNama.getText().toString());
        data.setUmur(Integer.parseInt(inpUmur.getText().toString()));
        data.setBeratBadan(Integer.parseInt(inpBeratBadan.getText().toString()));
        data.setTekananDarah(inpTekananDarah.getText().toString());
        data.setAlamat(inpAlamat.getText().toString());
        data.save();

        Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AddDataActivity.this, MenuUtamaActivity.class);
        AddDataActivity.this.startActivity(intent);
      }
    });
  }
}