package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button btnmenu;
    private Button btninfo;
    private Button btnnote;
    private Button btndeco;
    private ImageButton btnburger;
    private String page_preced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        initialisation();
    }

    private void initialisation(){

        Intent intent = getIntent();
        if (intent.hasExtra("page_preced")) {
            page_preced = intent.getStringExtra("page_preced");
        }

        btnmenu = (Button) findViewById(R.id.btnmenu);
        btninfo = (Button) findViewById(R.id.btninfo);
        btnnote = (Button) findViewById(R.id.btnnote);
        btndeco = (Button) findViewById(R.id.btndeco);
        btnburger = (ImageButton) findViewById(R.id.btnburger);


        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, PageAcceuil.class);
                startActivity(intent);
            }
        });

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, PageInfo.class);
                startActivity(intent);
            }
        });

        btnnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, PageNote.class);
                startActivity(intent);
            }
        });

        btndeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UtilisateurDAO utilisateurDAO = new UtilisateurDAO(Menu.this);
                utilisateurDAO.open();
                utilisateurDAO.deleteUtilisateur();
                utilisateurDAO.close();
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if(page_preced.equals("acceuil")){
            btnburger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, PageAcceuil.class);
                    startActivity(intent);
                }
            });

        } else if (page_preced.equals("info")) {
            btnburger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, PageInfo.class);
                    startActivity(intent);
                }
            });

        }else if(page_preced.equals("note")){
            btnburger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Menu.this, PageNote.class);
                    startActivity(intent);
                }
            });

        }

    }

}
