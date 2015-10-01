package com.example.lucas.alunos_material.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.dao.AlunoDAO;
import com.example.lucas.alunos_material.helper.FormularioAlunoHelper;
import com.example.lucas.alunos_material.modelo.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    FormularioAlunoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarForAluno);
        toolbar.setTitle("Novo Aluno");
        setSupportActionBar(toolbar);

        helper = new FormularioAlunoHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnConfirmaAluno) {

            Aluno aluno = helper.pegaAlunoDoFormulario();

            AlunoDAO dao = new AlunoDAO(FormularioAlunoActivity.this);
            dao.insere(aluno);


            Toast.makeText(FormularioAlunoActivity.this, "Aluno Cadastrado", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
