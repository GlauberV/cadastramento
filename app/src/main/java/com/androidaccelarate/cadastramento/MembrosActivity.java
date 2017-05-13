package com.androidaccelarate.cadastramento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MembrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membros);

        String[] membros = {"Alex", "Pedro"};
        ListView listaDeMembros = (ListView) findViewById(R.id.membros_lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, membros);
        listaDeMembros.setAdapter(adapter);


    }
}
