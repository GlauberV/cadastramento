package com.androidaccelarate.cadastramento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button entrar;
    Button cadastrar;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.main_imagem);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MembrosActivity.class);
                startActivity(i);
            }
        });

        entrar = (Button) findViewById(R.id.main_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EntrarActivity.class);
                startActivity(i);
            }
        });

        cadastrar = (Button) findViewById(R.id.main_cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastroIntent = new Intent(MainActivity.this, CadastroActivity.class);
                MainActivity.this.startActivity(cadastroIntent);
            }
        });
    }
}
