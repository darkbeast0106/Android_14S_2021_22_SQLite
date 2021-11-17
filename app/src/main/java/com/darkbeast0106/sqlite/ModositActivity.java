package com.darkbeast0106.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModositActivity extends AppCompatActivity {
    private Button btnModosit;
    private Button btnVissza;
    private EditText editID;
    private EditText editVezNev;
    private EditText editKerNev;
    private EditText editJegy;
    private DBHelper adatbazis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modosit);
        init();
        btnVissza.setOnClickListener(v -> {
            Intent vissza = new Intent(this, MainActivity.class);
            startActivity(vissza);
            finish();
        });
        btnModosit.setOnClickListener(v -> {
            String id = editID.getText().toString().trim();
            String vezeteknev = editVezNev.getText().toString().trim();
            String keresztnev = editKerNev.getText().toString().trim();
            String jegyString = editJegy.getText().toString().trim();
            if (id.isEmpty() || vezeteknev.isEmpty() || keresztnev.isEmpty() || jegyString.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Minden mező kitöltése kötelező",
                        Toast.LENGTH_SHORT).show();
            } else {
                if (adatbazis.modosit(id, vezeteknev, keresztnev, jegyString) == 0) {
                    String uzenet = "Sikertelen módosítás, az adott id-val nem létezik rekord";
                    Toast.makeText(this, uzenet, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Sikeres módosítás", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        btnModosit = findViewById(R.id.btn_modosit);
        btnVissza = findViewById(R.id.btn_vissza_modosit);
        editID = findViewById(R.id.modosit_id);
        editVezNev = findViewById(R.id.modosit_vnev);
        editKerNev = findViewById(R.id.modosit_knev);
        editJegy = findViewById(R.id.modosit_jegy);
        adatbazis = new DBHelper(this);
    }
}