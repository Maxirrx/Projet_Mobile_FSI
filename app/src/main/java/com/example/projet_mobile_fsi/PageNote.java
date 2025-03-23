package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PageNote extends AppCompatActivity {

    private ImageButton btnburger;
    private TextView notoral1;
    private TextView notoral2;
    private TextView noteent;
    private TextView notedoss1;
    private TextView notedoss2;
    private TextView remarque1;
    private TextView remarque2;

    private String nom_de_page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_note);
        initialisation();
    }

    private void initialisation(){

        nom_de_page = "note";

        btnburger = (ImageButton) findViewById(R.id.btnburger);
        notoral1 = (TextView) findViewById(R.id.notoral1);
        notoral2 = (TextView) findViewById(R.id.notoral2);
        noteent = (TextView) findViewById(R.id.noteent);
        notedoss1 = (TextView) findViewById(R.id.notedoss1);
        notedoss2 = (TextView) findViewById(R.id.notedoss2);
        remarque1 = (TextView) findViewById(R.id.remarque1);
        remarque2 = (TextView) findViewById(R.id.remarque2);

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(this);
        utilisateurDAO.open();
        Utilisateur utilisateur = utilisateurDAO.getsoloUtilisateur();

        notoral1.setText(String.valueOf(utilisateur.getNoteOralBil1() != 0.0 ? utilisateur.getNoteOralBil1() : ""));
        notoral2.setText(String.valueOf(utilisateur.getNoteOralBil2()!= 0.0 ? utilisateur.getNoteOralBil2() : ""));
        noteent.setText(String.valueOf(utilisateur.getNoteEntBil1()!= 0.0 ? utilisateur.getNoteEntBil1() : ""));
        notedoss1.setText(String.valueOf(utilisateur.getNotBil1()!= 0.0 ? utilisateur.getNotBil1() : ""));
        notedoss2.setText(String.valueOf(utilisateur.getNoteBil2()!= 0.0 ? utilisateur.getNoteBil2() : ""));
        remarque1.setText(utilisateur.getRemarqueBil1() != null ? utilisateur.getRemarqueBil1() : "");
        remarque2.setText(utilisateur.getSujMemoire() != null ? utilisateur.getSujMemoire() : "");

        btnburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageNote.this, Menu.class);
                intent.putExtra("page_preced", nom_de_page);
                startActivity(intent);
            }
        });

    }

}
