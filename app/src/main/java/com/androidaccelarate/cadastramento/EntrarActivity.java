package com.androidaccelarate.cadastramento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidaccelarate.cadastramento.dao.PessoaDAO;

public class EntrarActivity extends AppCompatActivity {

    CadastroHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        final EditText entradaNome = (EditText) findViewById(R.id.entrar_activity_nome);
        final EditText entradaSenha = (EditText) findViewById(R.id.entrar_activity_senha);


        Button acessar = (Button) findViewById(R.id.entrar_activity_button);
        acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PessoaDAO pessoaDAO = new PessoaDAO(EntrarActivity.this);

                if (pessoaDAO.validarEntrada(entradaNome.getText().toString(), entradaSenha.getText().toString())) {
                    Intent intentVaiParaAreaDeMembros = new Intent(EntrarActivity.this, MembrosActivity.class);
                    startActivity(intentVaiParaAreaDeMembros);
                    finish();
                } else {
                    String oqsaiu = entradaNome.getText().toString() + entradaSenha.getText().toString();
                    Toast.makeText(EntrarActivity.this, "Dados Invalidos" + oqsaiu, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
