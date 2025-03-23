package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PageInfo extends AppCompatActivity {

    private ImageButton btnburger;
    private TextView nom;
    private TextView prenom;
    private TextView telephone;
    private TextView adresse;
    private TextView mail;
    private TextView classe;
    private TextView noment;
    private TextView adresseent;
    private TextView nommaitre;
    private TextView telmaitre;
    private TextView mailmaitre;
    private Button btnmodif;
    private String nom_de_page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_info);
        initialisation();
    }

    private void initialisation(){

        nom_de_page = "info";
        btnmodif = (Button) findViewById(R.id.btnmodif);
        btnburger = (ImageButton) findViewById(R.id.btnburger);
        nom = (TextView) findViewById(R.id.nom);
        prenom = (TextView) findViewById(R.id.prenom);
        telephone = (TextView) findViewById(R.id.telephone);
        adresse = (TextView) findViewById(R.id.adresse);
        mail = (TextView) findViewById(R.id.mail);
        classe = (TextView) findViewById(R.id.classe);
        noment = (TextView) findViewById(R.id.noment);
        adresseent = (TextView) findViewById(R.id.adresseent);
        nommaitre = (TextView) findViewById(R.id.nommaitre);
        telmaitre = (TextView) findViewById(R.id.telmaitre);
        mailmaitre = (TextView) findViewById(R.id.mailmaitre);

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(this);
        utilisateurDAO.open();
        Utilisateur utilisateur = utilisateurDAO.getsoloUtilisateur();


        nom.setText(!utilisateur.getNomUti().equals("vide") ? utilisateur.getNomUti() : "");
        prenom.setText(!utilisateur.getPrenomUti().equals("vide") ? utilisateur.getPrenomUti() : "");
        telephone.setText(!utilisateur.getTelMA().equals("vide") ? utilisateur.getTelMA() : "");
        adresse.setText(!utilisateur.getAdresseUti().equals("vide") ? utilisateur.getAdresseUti() : "");
        mail.setText(!utilisateur.getMailUti().equals("vide") ? utilisateur.getMailUti() : "");
        classe.setText(!utilisateur.getmaclasse().equals("vide") ? utilisateur.getmaclasse() : "");
        noment.setText(!utilisateur.getNomEnt().equals("vide") ? utilisateur.getNomEnt() : "");
        adresseent.setText(!utilisateur.getAdresseEnt().equals("vide") ? utilisateur.getAdresseEnt() : "");
        nommaitre.setText(!utilisateur.getNomMA().equals("vide") ? utilisateur.getNomMA() : "");
        telmaitre.setText(!utilisateur.getTelEnt().equals("vide") ? utilisateur.getTelEnt() : "");
        mailmaitre.setText(!utilisateur.getMailMA().equals("vide") ? utilisateur.getMailMA() : "");




        btnburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageInfo.this, Menu.class);
                intent.putExtra("page_preced", nom_de_page);
                startActivity(intent);
            }
        });

        btnmodif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageInfo.this, Pagemodif.class);
                startActivity(intent);
            }
        });

    }
}
