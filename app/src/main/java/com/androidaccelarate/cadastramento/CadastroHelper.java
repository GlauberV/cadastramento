package com.androidaccelarate.cadastramento;

import android.widget.EditText;

import com.androidaccelarate.cadastramento.modelo.Pessoa;

public class CadastroHelper {

    private final EditText campoNome;
    private final EditText campoTelefone;
    private final EditText campoEmail;
    private final EditText campoSenha;

    public CadastroHelper(CadastroActivity cadastro) {
        campoNome = (EditText) cadastro.findViewById(R.id.cadastro_nome);
        campoTelefone = (EditText) cadastro.findViewById(R.id.cadastro_telefone);
        campoEmail = (EditText) cadastro.findViewById(R.id.cadastro_email);
        campoSenha = (EditText) cadastro.findViewById(R.id.cadastro_senha);
    }

    public Pessoa pegaPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(campoNome.getText().toString());
        pessoa.setTelefone(campoTelefone.getText().toString());
        pessoa.setEmail(campoEmail.getText().toString());
        pessoa.setSenha(campoSenha.getText().toString());

        return pessoa;
    }
}

  /*
    Assim que se recupera os dados
    EditText campoNome = (EditText) findViewById(R.id.cadastro_nome);
    String nome = campoNome.getText().toString();

    EditText campoTelefone = (EditText) findViewById(R.id.cadastro_telefone);
    String telefone = campoTelefone.getText().toString();

    EditText campoEmail = (EditText) findViewById(R.id.cadastro_email);
    String email = campoEmail.getText().toString();

    EditText campoSenha = (EditText) findViewById(R.id.cadastro_senha);
    String senha = campoSenha.getText().toString();
  */