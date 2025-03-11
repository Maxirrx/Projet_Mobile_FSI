package com.example.projet_mobile_fsi;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENT = "Etudiant";
    private static final String DB_NAME = "FSI.db";
    private static final int DB_VERSION = 1;

    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS " + TABLE_COMMENT + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nomUti TEXT, " +
            "prenomUti TEXT, " +
            "adresseUti TEXT, " +
            "mailUti TEXT, " +
            "nomMA TEXT, " +
            "prenomMA TEXT, " +
            "telMA TEXT, " +
            "mailMA TEXT, " +
            "nomEnt TEXT, " +
            "adresseEnt TEXT, " +
            "telEnt TEXT, " +
            "mailEnt TEXT, " +
            "libBil1 TEXT, " +
            "notBil1 TEXT, " +
            "remarqueBil1 TEXT, " +
            "noteEntBil1 TEXT, " +
            "noteOralBil1 TEXT, " +
            "dateBil1 TEXT, " +
            "libBil2 TEXT, " +
            "noteBil2 TEXT, " +
            "noteOralBil2 TEXT, " +
            "sujMemoire TEXT, " +
            "dateBil2 TEXT );";

    public SQLHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLHelper.class.getName(), "changement de version");
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_COMMENT);
        onCreate(db);
    }

}
