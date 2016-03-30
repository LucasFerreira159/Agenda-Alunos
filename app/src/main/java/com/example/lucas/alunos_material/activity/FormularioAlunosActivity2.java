package com.example.lucas.alunos_material.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.dao.AlunoDAO;
import com.example.lucas.alunos_material.helper.FormularioAlunoHelper;
import com.example.lucas.alunos_material.modelo.Aluno;

import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class FormularioAlunosActivity2 extends AppCompatActivity {

    FormularioAlunoHelper helper;
    Aluno alunoAlterado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_alunos2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarForAluno);
        toolbar.setTitle("Novo Aluno");
        setSupportActionBar(toolbar);

        helper = new FormularioAlunoHelper(this);

        //Recuperando informações de outra activity
        alunoAlterado = (Aluno) getIntent().getSerializableExtra("alunoSelecionado");


           /* Verifica se esta vindo um dado ou não
            se estiver , vai atualizar, se vir nulo vai cadastrar um novo*/
        if(alunoAlterado != null){
            helper.colocaAlunoNoFormulario(alunoAlterado);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabFoto);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                String caminhoFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
                File arquivoFoto = new File(caminhoFoto);

                camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivoFoto));
                startActivity(camera);
            }
        });

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
            AlunoDAO dao = new AlunoDAO(FormularioAlunosActivity2.this);

            if(alunoAlterado != null){
                aluno.setId(alunoAlterado.getId());
                dao.atualizar(aluno);
            }else{

                dao.insere(aluno);
                Toast.makeText(FormularioAlunosActivity2.this, "Aluno Cadastrado", Toast.LENGTH_SHORT).show();
            }

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
