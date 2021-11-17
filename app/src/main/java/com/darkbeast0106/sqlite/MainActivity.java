package com.darkbeast0106.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnListaz;
    private Button btnRogzitesre;
    private Button btnModositasra;
    private Button btnTorlesre;
    private TextView textLista;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        textLista.setMovementMethod(new ScrollingMovementMethod());
        btnRogzitesre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rogzitesre = new Intent(MainActivity.this, RogzitesActivity.class);
                startActivity(rogzitesre);
                finish();
            }
        });
        btnTorlesre.setOnClickListener(v -> {
            Intent torlesre = new Intent(MainActivity.this, TorlesActivity.class);
            startActivity(torlesre);
            finish();
        });
        btnListaz.setOnClickListener(v -> {
            Cursor adatok = adatbazis.listaz();
            if (adatok.getCount() == 0){
                Toast.makeText(this, "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
            } else {
                StringBuilder bobTheBuilder = new StringBuilder();
                while (adatok.moveToNext()){
                    bobTheBuilder.append("ID: ").append(adatok.getInt(0));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Vezeteknév: ").append(adatok.getString(1));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Keresztnév: ").append(adatok.getString(2));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Jegy: ").append(adatok.getInt(3));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append(System.lineSeparator());
                }
                textLista.setText(bobTheBuilder.toString());
            }
        });
    }

    private void init(){
        btnListaz = findViewById(R.id.btn_olvasas);
        btnRogzitesre = findViewById(R.id.btn_rogzitesre);
        btnModositasra = findViewById(R.id.btn_modositasra);
        btnTorlesre = findViewById(R.id.btn_torlesre);
        textLista = findViewById(R.id.text_lista);
        adatbazis = new DBHelper(this);
    }
}