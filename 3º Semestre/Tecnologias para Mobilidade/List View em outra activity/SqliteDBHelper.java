package com.example.wagner.sqlite_crud_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Aluno_2 on 18/04/2016.
 */
public class SqliteDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Coordenadas.db";
    //public static final String TABLE_NAME = TblCoordenadas;

    //private static final String TEXT_TYPE = " TEXT";
    //private static final String COMMA_SEP = ",";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE TblCoordenadas ( " +
                    "_id INTEGER PRIMARY KEY autoincrement," +
                    "Latitude TEXT_TYPE, "+
                    "Longitude TEXT_TYPE "+
                    " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS TblCoordenadas";


    //C O N S T R U T O R
    public SqliteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //C A L L B A C K S
    public void onCreate(SQLiteDatabase db) {
        Log.i("SqliteDBHelper", "public void onCreate(SQLiteDatabase " + db + " ) ");
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        Log.i("SqliteDBHelper","public void onUpgrade(SQLiteDatabase "+db+", int "+oldVersion+", int "+newVersion+") {");
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("SqliteDBHelper","public void onDowngrade(SQLiteDatabase "+db+", int "+oldVersion+", int "+newVersion+") {");
        onUpgrade(db, oldVersion, newVersion);
    }
}
