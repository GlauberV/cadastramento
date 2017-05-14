package com.androidaccelarate.cadastramento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidaccelarate.cadastramento.com.androidaccelerate.cadastramento.modelo.Pessoa;
import com.androidaccelarate.cadastramento.dao.PessoaDAO;

public class CadastroActivity extends AppCompatActivity {

    private CadastroHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        helper = new CadastroHelper(this);

        Button registrar = (Button) findViewById(R.id.cadastro_button);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa pessoa = helper.pegaPessoa();
                PessoaDAO pessoaDAO = new PessoaDAO(CadastroActivity.this);
                pessoaDAO.inserePessoa(pessoa);
                pessoaDAO.close();

                String toastText = "Nome: " + pessoa.getNome() + "\nTelefone: " + pessoa.getTelefone() + "\nEmail: " + pessoa.getEmail() + "\nSenha: " + pessoa.getSenha();

                Toast toast = Toast.makeText(CadastroActivity.this, toastText, Toast.LENGTH_LONG);
                toast.show();

                finish();
            }
        });
    }
}
