package com.example.lucas.alunos_material.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.activity.FormularioAlunoActivity;
import com.example.lucas.alunos_material.modelo.Aluno;

/**
 * Created by Lucas on 01/10/2015.
 */
public class FormularioAlunoHelper {

    private EditText campoNome, campoEndereco, campoSite, campoTelefone;
    private RatingBar campoNota;
    Aluno aluno;

    public FormularioAlunoHelper(FormularioAlunoActivity f) {

        campoNome = (EditText) f.findViewById(R.id.nome);
        campoEndereco = (EditText) f.findViewById(R.id.endereco);
        campoSite = (EditText) f.findViewById(R.id.site);
        campoTelefone = (EditText) f.findViewById(R.id.telefone);
        campoNota = (RatingBar) f.findViewById(R.id.nota);
    }

    public Aluno pegaAlunoDoFormulario(){

        String nome = campoNome.getText().toString();
        String endereco = campoEndereco.getText().toString();
        String site = campoSite.getText().toString();
        String telefone = campoTelefone.getText().toString();
        double nota = campoNota.getRating();

        aluno = new Aluno();

        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setSite(site);
        aluno.setTelefone(telefone);
        aluno.setNota(nota);

        return aluno;
    }
}
