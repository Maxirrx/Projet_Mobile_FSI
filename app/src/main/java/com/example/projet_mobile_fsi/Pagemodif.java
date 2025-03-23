package com.example.projet_mobile_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pagemodif extends AppCompatActivity {


    private TextView nom;
    private TextView prenom;
    private EditText telephone;
    private EditText adresse;
    private EditText mail;
    private TextView classe;
    private Button btnvalid;
    private Button btnannul;
    private String telephoneval;
    private String adresseval;
    private String mailval;
    private int id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_modif);
        initialisation();
    }

    private void initialisation(){


        btnvalid = (Button) findViewById(R.id.btnvalid);
        btnannul = (Button) findViewById(R.id.btnannul);
        nom = (TextView) findViewById(R.id.nom1);
        prenom = (TextView) findViewById(R.id.prenom1);
        telephone = (EditText) findViewById(R.id.telephone1);
        adresse = (EditText) findViewById(R.id.adresse1);
        mail = (EditText) findViewById(R.id.mail1);
        classe = (TextView) findViewById(R.id.classe1);


        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(this);
        utilisateurDAO.open();
        Utilisateur utilisateur = utilisateurDAO.getsoloUtilisateur();


        nom.setText(utilisateur.getNomUti());
        prenom.setText(utilisateur.getPrenomUti());
        telephone.setText("vide".equals(String.valueOf(utilisateur.getTelMA())) ? " " : String.valueOf(utilisateur.getTelMA()));
        adresse.setText( "vide".equals(String.valueOf(utilisateur.getAdresseUti())) ? " " : String.valueOf(utilisateur.getAdresseUti()));
        mail.setText("vide".equals(String.valueOf(utilisateur.getMailUti())) ? " " : String.valueOf(utilisateur.getMailUti()) );
        classe.setText(utilisateur.getmaclasse());





        btnannul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pagemodif.this, PageInfo.class);
                startActivity(intent);
            }
        });

        btnvalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adresseval = adresse.getText().toString();
                Log.d("qsdf", adresseval);
                telephoneval = telephone.getText().toString();
                mailval = mail.getText().toString();

                UtilisateurDAO utilisateurDAO = new UtilisateurDAO(Pagemodif.this);
                utilisateurDAO.open();

                Utilisateur utilisateur = new Utilisateur();
                utilisateur = utilisateurDAO.getsoloUtilisateur();
                id = utilisateur.getId();

                RetroFitClientUtilisateur.getInstance()
                        .getMyApi()
                        .update("1", id, adresseval, telephoneval, mailval)
                        .enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.isSuccessful()) {

                                    Utilisateur utilisateur = new Utilisateur();
                                    utilisateur = utilisateurDAO.getsoloUtilisateur();

                                    utilisateurDAO.deleteUtilisateur();

                                    utilisateur.setAdresseUti(adresseval);
                                    utilisateur.setTelMA(telephoneval);
                                    utilisateur.setMailUti(mailval);
                                    utilisateurDAO.insertuser(utilisateur);

                                    utilisateurDAO.close();

                                    Intent intent = new Intent(Pagemodif.this, PageInfo.class);
                                    startActivity(intent);

                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("rererer", "erreur");
                            }
                        });


            }
        });

    }
}
