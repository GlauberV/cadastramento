package com.androidaccelarate.cadastramento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class EntrarActivity extends AppCompatActivity {

    private EditText nome;
    private EditText senha;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
    }
}
