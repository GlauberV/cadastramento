package com.androidaccelarate.cadastramento.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PessoaDAO extends SQLiteOpenHelper{

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
}
