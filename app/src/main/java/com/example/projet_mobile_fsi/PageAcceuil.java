package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PageAcceuil extends AppCompatActivity {

    private ImageButton btnburger;
    private String nom_de_page;
    private TextView textView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_acceuil);
        initialisation();
    }

    private void initialisation(){

        nom_de_page = "acceuil";

        btnburger = (ImageButton) findViewById(R.id.btnburger);
        textView2 = (TextView) findViewById(R.id.textView2);

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(this);
        utilisateurDAO.open();


        textView2.setText("Bonjour " + utilisateurDAO.getsoloUtilisateur().getPrenomUti());

        btnburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAcceuil.this, Menu.class);
                intent.putExtra("page_preced", nom_de_page);
                startActivity(intent);
            }
        });

    }



}
