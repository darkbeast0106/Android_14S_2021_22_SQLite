package com.darkbeast0106.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RogzitesActivity extends AppCompatActivity {
    private Button btnRogzit;
    private Button btnVissza;
    private EditText editVezNev;
    private EditText editKerNev;
    private EditText editJegy;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rogzites);
        init();
        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(RogzitesActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
        btnRogzit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vezeteknev = editVezNev.getText().toString().trim();
                String keresztnev = editKerNev.getText().toString().trim();
                String jegyString = editJegy.getText().toString().trim();
                if (vezeteknev.isEmpty() || keresztnev.isEmpty() || jegyString.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Minden mező kitöltése kötelező",
                            Toast.LENGTH_SHORT).show();
                } else{
                    try {
                        int jegy = Integer.parseInt(jegyString);
                        if (jegy < 1 || jegy > 5){
                            Toast.makeText(getApplicationContext(),
                                    "A jegynek 1 és 5 közötti számnak kell lennie",
                                    Toast.LENGTH_SHORT).show();
                        } else{
                            if (adatbazis.rogzites(vezeteknev, keresztnev, jegy)){
                                Toast.makeText(getApplicationContext(), "Sikeres rögzítés",
                                        Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(getApplicationContext(), "Sikeretelen rögzítés",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(getApplicationContext(), "A jegynek számnak kell lennie",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void init(){
        btnRogzit = findViewById(R.id.btn_rogzit);
        btnVissza = findViewById(R.id.btn_vissza);
        editVezNev = findViewById(R.id.edit_vnev);
        editKerNev = findViewById(R.id.edit_knev);
        editJegy = findViewById(R.id.edit_jegy);
        adatbazis = new DBHelper(this);
    }
}