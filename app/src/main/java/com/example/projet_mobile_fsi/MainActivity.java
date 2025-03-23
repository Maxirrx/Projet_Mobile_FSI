package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText mdp;
    private Button btnconnect;
    private String loginval;
    private String mdpval ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initialisation();
    }

    private void initialisation(){

        btnconnect = (Button) findViewById(R.id.btnconnect);
        login = (EditText) findViewById(R.id.login);
        mdp = (EditText) findViewById(R.id.mdp);


        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(this);
        utilisateurDAO.open();

        if(utilisateurDAO.getsoloUtilisateur() != null){
            Intent intent = new Intent(MainActivity.this, PageAcceuil.class);
            startActivity(intent);

        }

        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(utilisateurDAO.getsoloUtilisateur() == null){

                loginval = login.getText().toString();
                mdpval = mdp.getText().toString();

                if(loginval.isEmpty() || mdpval.isEmpty()){
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }else {



                    RetroFitClientUtilisateur.getInstance()
                            .getMyApi()
                            .divin(loginval, mdpval)
                            .enqueue(new Callback<Utilisateur>() {
                                @Override
                                public void onResponse(Call<Utilisateur> call, retrofit2.Response<Utilisateur> response) {
                                    if (response.isSuccessful() && response.body() != null) {
                                        Utilisateur utilisateur = response.body();


                                        utilisateurDAO.insertuser(utilisateur);

                                        utilisateurDAO.close();


                                        Intent intent = new Intent(MainActivity.this, PageAcceuil.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Authentification échouée", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Utilisateur> call, Throwable t) {
                                    t.printStackTrace();
                                    Toast.makeText(MainActivity.this, "Erreur réseau ou serveur", Toast.LENGTH_SHORT).show();
                                }
                            });
                }



            }
            }
        });

    }

}