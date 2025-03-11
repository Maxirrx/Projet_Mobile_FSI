package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PageNote extends AppCompatActivity {

    private ImageButton btnburger;
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
