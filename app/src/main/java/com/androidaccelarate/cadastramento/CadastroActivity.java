package com.androidaccelarate.cadastramento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidaccelarate.cadastramento.dao.PessoaDAO;
import com.androidaccelarate.cadastramento.modelo.Pessoa;

public class CadastroActivity extends AppCompatActivity {

    private CadastroHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        helper = new CadastroHelper(this);

        Button registrar = (Button) findViewById(R.id.cadastro_button);
        registrar.setOnClickListener(new View.OnClickListener() {

            String toastText;

            @Override
            public void onClick(View v) {
                Pessoa pessoa = helper.pegaPessoa();
                PessoaDAO pessoaDAO = new PessoaDAO(CadastroActivity.this);

                if(pessoaDAO.verificarCadstroRepetido(pessoa)){

                    pessoaDAO.inserirPessoa(pessoa);

                    toastText = "Cliente (" + pessoa.getNome() + ") foi adicionado com sucesso";
                    Toast toast = Toast.makeText(CadastroActivity.this, toastText, Toast.LENGTH_SHORT);
                    toast.show();
                    finish();

                } else {

                    toastText = "Esses dados já estão cadastrados \nTente algo diferente :)";
                    Toast toast = Toast.makeText(CadastroActivity.this, toastText, Toast.LENGTH_LONG);
                    toast.show();
                }

                pessoaDAO.close();

            }
        });
    }
}
