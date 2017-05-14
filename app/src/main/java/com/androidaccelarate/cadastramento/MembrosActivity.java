package com.androidaccelarate.cadastramento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidaccelarate.cadastramento.modelo.Pessoa;
import com.androidaccelarate.cadastramento.dao.PessoaDAO;

import java.util.List;

public class MembrosActivity extends AppCompatActivity {

    private ListView listaDeMembros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membros);

        listaDeMembros = (ListView) findViewById(R.id.membros_lista);

        registerForContextMenu(listaDeMembros);
    }

    public void carregarListaDeMembros() {
        PessoaDAO dao = new PessoaDAO(MembrosActivity.this);
        List<Pessoa> membros = dao.buscarPessoa();
        dao.close();

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, membros);
        listaDeMembros.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaDeMembros();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("DELETAR");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Pessoa pessoa = (Pessoa) listaDeMembros.getItemAtPosition(info.position);

                PessoaDAO pessoaDAO = new PessoaDAO(MembrosActivity.this);
                pessoaDAO.deletarPessoa(pessoa);
                pessoaDAO.close();

                carregarListaDeMembros();

                return false;
            }
        });
    }
}
