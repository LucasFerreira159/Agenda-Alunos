package com.example.lucas.alunos_material.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.dao.AlunoDAO;
import com.example.lucas.alunos_material.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listViewAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewAlunos = (ListView) findViewById(R.id.listaDeAlunos);

        AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
        List<Aluno> alunos = dao.getLista();

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listViewAlunos.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                startActivity(i);
            }
        });
    }
}
