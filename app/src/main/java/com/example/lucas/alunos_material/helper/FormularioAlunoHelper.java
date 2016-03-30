package com.example.lucas.alunos_material.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.activity.FormularioAlunosActivity2;
import com.example.lucas.alunos_material.modelo.Aluno;

/**
 * Created by Lucas on 01/10/2015.
 */
public class FormularioAlunoHelper {

    private EditText campoNome, campoSite, campoTelefone;
    private String nome,site,telefone;
    private double nota;
    private RatingBar campoNota;
    Aluno aluno;

    public FormularioAlunoHelper(FormularioAlunosActivity2 f) {

        campoNome = (EditText) f.findViewById(R.id.nome);
        campoSite = (EditText) f.findViewById(R.id.site);
        campoTelefone = (EditText) f.findViewById(R.id.telefone);
        campoNota = (RatingBar) f.findViewById(R.id.nota);
    }

    public Aluno pegaAlunoDoFormulario(){

        nome = campoNome.getText().toString();
        site = campoSite.getText().toString();
        telefone = campoTelefone.getText().toString();
        nota = campoNota.getRating();

        aluno = new Aluno();

        aluno.setNome(nome);
        aluno.setSite(site);
        aluno.setTelefone(telefone);
        aluno.setNota(nota);

        return aluno;
    }

    public void colocaAlunoNoFormulario(Aluno alunoAlterado) {
       campoNome.setText(alunoAlterado.getNome());
       campoSite.setText(alunoAlterado.getSite());
       campoTelefone.setText(alunoAlterado.getTelefone());
       campoNota.setRating((float) alunoAlterado.getNota());
    }
}
