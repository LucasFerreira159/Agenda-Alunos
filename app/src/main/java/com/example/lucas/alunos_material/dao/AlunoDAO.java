package com.example.lucas.alunos_material.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.lucas.alunos_material.helper.DbHelper;
import com.example.lucas.alunos_material.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

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

    public void insere(Aluno aluno) {
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("telefone", aluno.getTelefone());
        cv.put("site", aluno.getSite());
        cv.put("nota", aluno.getNota());
        cv.put("foto", aluno.getFoto());

        try {
            escreve.insert(DbHelper.TAB_ALUNOS, null, cv);
            Log.i("INFO", "Dados Inseridos");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao Inserir Dado" + e.getMessage());
        }
    }

    public List<Aluno> getLista() {
        String sql = "SELECT * FROM " + DbHelper.TAB_ALUNOS + ";";
        Cursor c = le.rawQuery(sql, null);

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        while (c.moveToNext()){
            Aluno aluno = new Aluno();

            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
            aluno.setSite(c.getString(c.getColumnIndex("site")));
            aluno.setNota(c.getDouble(c.getColumnIndex("nota")));
            aluno.setFoto(c.getString(c.getColumnIndex("foto")));

            alunos.add(aluno);
        }
        return alunos;
    }
}
