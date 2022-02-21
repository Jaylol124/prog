package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    Button wash, atlan,chica;
    ImageView img;



    Hashtable <String, Integer> listeclub = new Hashtable<String, Integer>(); //creer la table de hashage
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wash = findViewById(R.id.bWash); // connecter les boutons
        atlan = findViewById(R.id.bAtlanta);
        chica = findViewById(R.id.bChicago);
        img = findViewById(R.id.imgclub);


        Ecouteur ec = new Ecouteur();

        wash.setOnClickListener(ec); // relier  l'ecouteur aux boutons
        atlan.setOnClickListener(ec);
        chica.setOnClickListener(ec);


        listeclub.put ("Washington", R.drawable.washington);// mettre une cle string et l'image
        listeclub.put ("Chicago",R.drawable.chicago);
        listeclub.put ("Atlanta",R.drawable.atlanta);

    }


    private class Ecouteur implements View.OnClickListener
    {

        @Override
        public void onClick(View source) {


            Button trans = (Button) source; // transtipper en bouton

            String selc = trans.getText().toString(); // avoir le texte du bouton cliquer

            img.setImageResource( listeclub.get(selc)); // afficher l'image grace a la cle de la table

        }

    }
}