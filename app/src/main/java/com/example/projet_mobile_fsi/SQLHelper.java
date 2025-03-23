package com.example.projet_mobile_fsi;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENT = "Utilisateur";
    private static final String DB_NAME = "FSI.db";
    private static final int DB_VERSION = 3;

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
            "maclasse TEXT, " +
            "libBil1 TEXT, " +
            "notBil1 INTEGER, " +
            "remarqueBil1 TEXT, " +
            "noteEntBil1 INTEGER, " +
            "noteOralBil1 INTEGER, " +
            "dateBil1 TEXT, " +
            "noteBil2 INTEGER, " +
            "noteOralBil2 INTEGER, " +
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
