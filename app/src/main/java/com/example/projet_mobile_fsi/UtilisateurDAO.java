package com.example.projet_mobile_fsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UtilisateurDAO {
    private SQLiteDatabase sqLiteDatabase;
    private SQLHelper db;

    public UtilisateurDAO(Context context){
        db = new SQLHelper(context);
    }

    public void open () throws SQLException {
        sqLiteDatabase = db.getWritableDatabase();
    }

    public String info(){
        return db.TABLE_COMMENT;
    }

    public void close(){
        db.close();
    }

    public Utilisateur insertuser(Utilisateur utilisateur){
        ContentValues values = new ContentValues();
        values.put("id", utilisateur.getId());
        values.put("nomUti", utilisateur.getNomUti());
        values.put("prenomUti", utilisateur.getPrenomUti());
        values.put("adresseUti", utilisateur.getAdresseUti());
        values.put("mailUti", utilisateur.getMailUti());
        values.put("nomMA", utilisateur.getNomMA());
        values.put("prenomMA", utilisateur.getPrenomMA());
        values.put("telMA", utilisateur.getTelMA());
        values.put("mailMA", utilisateur.getMailMA());
        values.put("nomEnt", utilisateur.getNomEnt());
        values.put("adresseEnt", utilisateur.getAdresseEnt());
        values.put("telEnt", utilisateur.getTelEnt());
        values.put("mailEnt", utilisateur.getMailEnt());
        values.put("libBil1", utilisateur.getLibBil1());
        values.put("notBil1", utilisateur.getNotBil1());
        values.put("remarqueBil1", utilisateur.getRemarqueBil1());
        values.put("noteEntBil1", utilisateur.getNoteEntBil1());
        values.put("noteOralBil1", utilisateur.getNoteOralBil1());
        values.put("dateBil1", utilisateur.getDateBil1());
        values.put("libBil2", utilisateur.getLibBil2());
        values.put("noteBil2", utilisateur.getNoteBil2());
        values.put("noteOralBil2", utilisateur.getNoteOralBil2());
        values.put("sujMemoire", utilisateur.getSujMemoire());
        values.put("dateBil2", utilisateur.getDateBil2());
        int id  = (int) sqLiteDatabase.insert("Utilisateur", null, values);
        utilisateur.setId(id);

        return utilisateur;
    }

    public Utilisateur getsoloUtilisateur() {
        Utilisateur unutilsateur = null;

        Cursor cursor = sqLiteDatabase.query(true, "Utilisateur", new String[]{"id", "nomUti", "prenomUti", "adresseUti", "mailUti", "nomMA", "prenomMA", "telMA", "mailMA", "nomEnt", "adresseEnt", "telEnt", "mailEnt", "libBil1", "notBil1", "remarqueBil1", "noteEntBil1", "noteOralBil1", "dateBil1", "libBil2", "noteBil2", "noteOralBil2", "sujMemoire", "dateBil2"}, null, null, null, null, null, "1" // LIMIT 1 pour récupérer un seul utilisateur
        );

        if (cursor.moveToFirst()) {
            unutilsateur = cursorToUtilisateur(cursor);
        }

        cursor.close();
        return unutilsateur;
    }


    public void deleteUtilisateur(){
        sqLiteDatabase.delete("Utilisateur", null, null);
    }

    private Utilisateur cursorToUtilisateur(Cursor cursor) {
        Utilisateur cursorutilsateur = new Utilisateur(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getInt(14), cursor.getString(15), cursor.getDouble(16), cursor.getDouble(17), cursor.getString(18), cursor.getString(19), cursor.getDouble(20), cursor.getInt(21), cursor.getString(22), cursor.getString(23));
        return cursorutilsateur;
    }
}
