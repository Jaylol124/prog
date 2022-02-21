package com.example.exer3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView boutonBidon, boutonBouteil, boutonVers;
    TextView champNiveau;
    ProgressBar progbar;
    int qte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonBidon = findViewById(R.id.imageBidon);
        boutonBouteil = findViewById(R.id.imageBouteil);
        boutonVers = findViewById(R.id.imageVers);
        champNiveau = findViewById(R.id.textQuantiter);
        progbar = findViewById(R.id.progressBar);

        //premiere etape
        Ecouteur ec = new Ecouteur();

        //2 etape

        boutonBidon.setOnClickListener(ec);
        boutonBouteil.setOnClickListener(ec);
        boutonVers.setOnClickListener(ec);

    }

    private class Ecouteur implements View.OnClickListener
    {
        double solde;
        String nomCompte;

        @Override
        public void onClick(View source) {

            if ( source == boutonBidon)
            {
//                nomCompte = String.valueOf(champNomCopmte.getText());
////                nomCompte = champNomCopmte.getText().toString();
//                nomCompte = nomCompte.trim(); // enlever les espaces
//                nomCompte = nomCompte.toUpperCase(); // en majuscule, plus facile a comparer
//                if (bonsChoix.contains(nomCompte))
//                {
//                    solde= 500;
//                    champSolde.setText("dsl ce nest pas possible");
//                }
                qte +=1500;

            }
            else if ( source == boutonBouteil)
            {
                qte +=350;

            }
            else if ( source == boutonVers)
            {

                qte+=150;
            }// bouton envoyer

            champNiveau.setText(String.valueOf(qte) + "ml");
            progbar.setProgress(qte);

            if (qte >=2000)
            {

                Toast toast = Toast.makeText(MainActivity.this,"Objectif reussi !",Toast.LENGTH_SHORT);
                toast.show();
                qte = 2000;
                champNiveau.setText(String.valueOf(qte) + "ml");
            }
        }

    }
}