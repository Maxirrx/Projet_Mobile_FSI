package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PageInfo extends AppCompatActivity {

    private ImageButton btnburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_info);
        initialisation();
    }

    private void initialisation(){
        btnburger = (ImageButton) findViewById(R.id.btnburger);

        btnburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageInfo.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}
