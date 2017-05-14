package com.androidaccelarate.cadastramento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidaccelarate.cadastramento.com.androidaccelerate.cadastramento.modelo.Pessoa;
import com.androidaccelarate.cadastramento.dao.PessoaDAO;

import java.util.List;

public class MembrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membros);

        PessoaDAO dao = new PessoaDAO(MembrosActivity.this);
        List<Pessoa> membros = dao.buscarPessoa();
        dao.close();

        ListView listaDeMembros = (ListView) findViewById(R.id.membros_lista);
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, membros);
        listaDeMembros.setAdapter(adapter);


    }
}
