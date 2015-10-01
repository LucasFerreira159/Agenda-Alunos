package com.example.lucas.alunos_material.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lucas.alunos_material.helper.DbHelper;
import com.example.lucas.alunos_material.modelo.Aluno;

/**
 * Created by Lucas on 01/10/2015.
 */
public class AlunoDAO {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public AlunoDAO(Context ctx) {
        DbHelper helper = new DbHelper(ctx);
        escreve = helper.getWritableDatabase();
        le = helper.getReadableDatabase();
    }

    public void insere(Aluno aluno){
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("telefone", aluno.getTelefone());
        cv.put("site", aluno.getSite());
        cv.put("nota", aluno.getNota());
        cv.put("foto", aluno.getFoto());

        try {
            escreve.insert(DbHelper.TAB_ALUNOS, null, cv);
            Log.i("INFO", "Dados Inseridos");
        }catch (Exception e){
            Log.e("INFO", "Erro ao Inserir Dado" + e.getMessage());
        }
    }
}
