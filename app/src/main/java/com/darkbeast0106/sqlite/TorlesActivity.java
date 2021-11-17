package com.darkbeast0106.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }
    private void init(){
        torlesID = findViewById(R.id.torles_id);
        btnTorles = findViewById(R.id.btn_torles);
        btnVissza = findViewById(R.id.btn_vissza_torles);
        adatbazis = new DBHelper(this);
    }
}