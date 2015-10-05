package com.example.lucas.alunos_material.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lucas on 01/10/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String NAME = "db_aluno";
    private static final int VERSION = 3;
    public static final String TAB_ALUNOS = "Alunos";

    public DbHelper(Context ctx) {
        super(ctx, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE " + TAB_ALUNOS
                    + " (id INTEGER PRIMARY KEY," +
                    "nome TEXT UNIQUE NOT NULL," +
                    "telefone TEXT NOT NULL," +
                    "site TEXT," +
                    "nota REAL," +
                    "foto TEXT" +
                    " );";

            db.execSQL(sql);
            Log.i("INFO", "Tabela foi criada com suceso" );
        }catch (Exception e){
            Log.e("INFO", "Erro ao Criar tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            String sql = "DROP TABLE IF EXISTS " + TAB_ALUNOS + ";";
            db.execSQL(sql);
            onCreate(db);

            Log.i("INFO", "Nova versao funcionando");
        }catch (Exception e){
            Log.e("INFO", "Erro ao dropar tabela" + e.getMessage());
        }
    }
}
