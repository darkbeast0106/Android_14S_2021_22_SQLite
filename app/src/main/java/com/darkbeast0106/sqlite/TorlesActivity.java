package com.darkbeast0106.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TorlesActivity extends AppCompatActivity {

    private EditText torlesID;
    private Button btnTorles;
    private Button btnVissza;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torles);
        init();
        btnVissza.setOnClickListener(v -> {
            Intent vissza = new Intent(this, MainActivity.class);
            startActivity(vissza);
            finish();
        });
        btnTorles.setOnClickListener(v -> {
            String torlendo = torlesID.getText().toString().trim();
            if (torlendo.isEmpty()){
                Toast.makeText(this, "Nem adtál meg ID-t", Toast.LENGTH_SHORT).show();
            } else {
                if (adatbazis.torles(torlendo) == 0) {
                    String uzenet = "Sikertelen törlés, az adott id-val nem létezik rekord";
                    Toast.makeText(this, uzenet, Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(this, "Sikeres törlés", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void init(){
        torlesID = findViewById(R.id.torles_id);
        btnTorles = findViewById(R.id.btn_torles);
        btnVissza = findViewById(R.id.btn_vissza_torles);
        adatbazis = new DBHelper(this);
    }
}