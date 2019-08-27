package com.example.uninove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Listagem extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String[] pessoasSerialized = intent.getStringArrayExtra("pessoas");
        List<Pessoa> people = new ArrayList<Pessoa>();

        // Capture the layout's TextView and set the string as its text
        ListView listView = findViewById(R.id.pessoasListView);

        for (String pessoa: pessoasSerialized) {
            people.add(new Pessoa(pessoa.split(" ")[0], pessoa.split(" ")[1]));
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, pessoasSerialized);

        listView.setAdapter(arrayAdapter);
    }
}
