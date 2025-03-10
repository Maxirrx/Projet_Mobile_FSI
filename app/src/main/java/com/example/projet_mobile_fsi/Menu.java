package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button btnmenu;
    private Button btninfo;
    private Button btnnote;
    private Button btndeco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        initialisation();
    }

    private void initialisation(){
        btnmenu = (Button) findViewById(R.id.btnmenu);
        btninfo = (Button) findViewById(R.id.btninfo);
        btnnote = (Button) findViewById(R.id.btnnote);
        btndeco = (Button) findViewById(R.id.btndeco);


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
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
