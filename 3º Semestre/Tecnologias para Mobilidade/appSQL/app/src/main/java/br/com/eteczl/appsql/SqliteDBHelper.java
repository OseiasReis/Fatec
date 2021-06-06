package br.com.eteczl.appsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Aluno_2 on 17/04/2016.
 */
public class SqliteDBHelper extends SQLiteOpenHelper{

    //VERSÃO DO BANCO DE DADOS... PODE MUDAR NO FUTURO..
    public static final int DATABASE_VERSION = 1;
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE TblCoordenadas ("+"Id INTEGER PRIMARY KEY,"+"Latitude TEXT_TYPE,"+"Longitude TEXT_TYPE"+")";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS TblCoordenadas";

    public static final String DATABASE_NAME = "Cordenadas.db";


    public SqliteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("SqliteDBHelper","Quando o Banco vai ser criando esse metodo roda...");
        //SE RODA AO CRIAR O BANCO, NADA MAIS SALUTAR QUE CRIAR A TABELA...
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("SqliteDBHelper","Esse metodo roda porque a versão do banco foi alterada");
        //NESTE CASO, A GENTE DROPA A TABELA E RECRIA O BANCO DE NO
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
