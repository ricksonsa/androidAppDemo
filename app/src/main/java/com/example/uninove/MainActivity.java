package com.example.uninove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;

    private TextView textView;
    private Button  btn;
    private Button btnGerar;

    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstNamePlainText);
        lastName = findViewById(R.id.lastNamePlainText);
        textView = findViewById(R.id.resultTextView);
        btn = findViewById(R.id.okBtn);
        btnGerar= findViewById(R.id.gerarBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String nome = firstName.getText().toString() + " " + lastName.getText().toString();
               Pessoa pessoa = new Pessoa(nome.split(" ")[0], nome.split(" ")[1]);
               pessoas.add(pessoa);
               textView.setText(nome + " adicionado.");
            }
        });

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sendPeople();
            }
        });
    }

    public void sendPeople() {
        Intent intent = new Intent(this, Listagem.class);
        intent.putExtra("pessoas", Pessoa.serializePeople(pessoas));
        startActivity(intent);
    }


}
