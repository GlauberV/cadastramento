package com.androidaccelarate.cadastramento.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidaccelarate.cadastramento.modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends SQLiteOpenHelper {

    public PessoaDAO(Context context) {
        super(context, "DataBase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Membros (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, telefone TEXT NOT NULL, email TEXT NOT NULL, senha TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Membros";
        db.execSQL(sql);
        onCreate(db);
    }


    public void inserirPessoa(Pessoa pessoa) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", pessoa.getNome());
        dados.put("telefone", pessoa.getTelefone());
        dados.put("email", pessoa.getEmail());
        dados.put("senha", pessoa.getSenha());

        db.insert("Membros", null, dados);
    }

    public List<Pessoa> buscarPessoa() {
        String sql = "SELECT * FROM Membros;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Pessoa> membros = new ArrayList<>();
        while (c.moveToNext()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(c.getLong(c.getColumnIndex("id")));
            pessoa.setNome(c.getString(c.getColumnIndex("nome")));
            pessoa.setTelefone(c.getString(c.getColumnIndex("telefone")));
            pessoa.setEmail(c.getString(c.getColumnIndex("email")));
            pessoa.setSenha(c.getString(c.getColumnIndex("senha")));

            membros.add(pessoa);
        }
        c.close();


        return membros;
    }

    public void deletarPessoa(Pessoa pessoa) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {pessoa.getId().toString()};

        db.delete("Membros", "id = ?", params);
    }

    public Boolean validarEntrada(String nome, String senha) {
        String sql = "SELECT * FROM Membros WHERE nome=? AND senha=?;";
        String[] params = {nome, senha};
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, params);

        boolean retorno;

        if (c != null && c.getCount() == 1) {
            retorno = true;
        } else {
            retorno = false;
        }

        c.close();
        return retorno;
    }
}

