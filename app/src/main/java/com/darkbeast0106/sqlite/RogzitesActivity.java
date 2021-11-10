package com.darkbeast0106.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RogzitesActivity extends AppCompatActivity {
    private Button btnRogzit;
    private Button btnVissza;
    private EditText editVezNev;
    private EditText editKerNev;
    private EditText editJegy;

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
    }

    private void init(){
        btnRogzit = findViewById(R.id.btn_rogzit);
        btnVissza = findViewById(R.id.btn_vissza);
        editVezNev = findViewById(R.id.edit_vnev);
        editKerNev = findViewById(R.id.edit_knev);
        editJegy = findViewById(R.id.edit_jegy);
    }
}