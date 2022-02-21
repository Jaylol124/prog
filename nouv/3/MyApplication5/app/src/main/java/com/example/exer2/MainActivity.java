package com.example.exer2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Button boutonValider, boutonEnvoyer;
    EditText champNomCopmte;
    TextView champCourriel, champSolde;
    Spinner spiner;

    Vector<String> bonsChoix;
    double solde;
    Compte compteChoisi;


    DecimalFormat df = new DecimalFormat("0.00$");

    Hashtable <String, Compte> listeComptes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        boutonValider = findViewById(R.id.buttonvalid);
        spiner = findViewById(R.id.spinnernom);
        champSolde = findViewById(R.id.textesolde);
        champCourriel = findViewById(R.id.couriel);
        boutonEnvoyer = findViewById(R.id.buttonEnvoyer);
        double solde;

        bonsChoix = new Vector<>();
        bonsChoix.add("CHEQUE");
        bonsChoix.add("EPARGNE");
        bonsChoix.add("EPAGNEPLUS");
        bonsChoix.add("CHEQUE");
        bonsChoix.add("EPAGNE");
        bonsChoix.add("EPAGNEPLUS");
        bonsChoix.add("EPAGNEPLUS");
        bonsChoix.add("EPAGNEPLUS");

        ArrayAdapter adapter =new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,bonsChoix);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);
        //premiere etape
        Ecouteur ec = new Ecouteur();

        //2 etape

//        boutonValider.setOnClickListener(ec);
        boutonEnvoyer.setOnClickListener(ec);
        spiner.setOnItemSelectedListener(ec);

        listeComptes = new Hashtable();

        listeComptes.put ("CHEQUE", new Compte( "cheque", 450));
        listeComptes.put ("EPARGNE", new Compte( "EPARGNE", 600));
        listeComptes.put ("EPARGNE plus", new Compte( "EPARGNE plus", 1200));


    }

    private class Ecouteur implements View.OnClickListener, AdapterView.OnItemSelectedListener
    {
        double solde;
        String nomCompte;

        @Override
        public void onClick(View source) {

            if ( source == boutonEnvoyer)
            {
                //nomCompte = spiner.getSelectedItem().toString();
//                nomCompte = champNomCopmte.getText().toString();
//                nomCompte = nomCompte.trim(); // enlever les espaces
//                nomCompte = nomCompte.toUpperCase(); // en majuscule, plus facile a comparer

                String courriel = String.valueOf(champCourriel.getText());
                courriel = courriel.trim();
                if(courriel.length() != 0)
                {
                    String montant = String.valueOf(champSolde.getText());
                    double transfert = Double.parseDouble( montant);


                    solde = compteChoisi.getSolde();

                    if ( transfert <= solde )
                    {
                        solde= solde - transfert;
                        champSolde.setText(df.format(solde));
                        compteChoisi.setSolde (solde);
                    }
                    else
                    {
                        champCourriel.setText("pas assez de fonds");
                        champTransfert.setText("0");
                    }
                }



            }
            else
            {

            }// bouton envoyer
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            TextView temp = (TextView)view;
            String cle_nomcompte = temp.getText().toString();

            //String cle = spiner.get(position);

            Compte compteChoisi = listeComptes.get(cle_nomcompte);
            champSolde.setText(df.format(compteChoisi.getSolde()));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}