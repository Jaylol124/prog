package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;

    String mdp ="", bonCode = "4444";
    ConstraintLayout parent;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        b0 = findViewById(R.id.button0);

        parent = findViewById(R.id.Parent);


        password = findViewById(R.id.lmdp);


        //premiere etape
        Ecouteur ec = new Ecouteur();

        //2 etape

        b1.setOnClickListener(ec);
        b2.setOnClickListener(ec);
        b3.setOnClickListener(ec);
        b4.setOnClickListener(ec);
        b5.setOnClickListener(ec);
        b6.setOnClickListener(ec);
        b7.setOnClickListener(ec);
        b8.setOnClickListener(ec);
        b9.setOnClickListener(ec);
        b0.setOnClickListener(ec);
        b0.setOnClickListener(ec);
        password.setOnClickListener(ec);

//        for (int i = 0; i < parent.getChildCount(); i++) {
//            if (parent.getChildAt(i) instanceof Button)
//            {
//                parent.getChildAt(i).setOnClickListener(ec);
//            }
//
//        }
    }

    private class Ecouteur implements View.OnClickListener
    {
        double solde;
        String nomCompte;

        @Override
        public void onClick(View source) {


            Button b = (Button) source;
            if ( mdp.length()<4)
            {
                mdp += b.getText().toString();
                password.setText(mdp);
            }



            if (mdp.length()==4)
            {
                if (mdp.equals(bonCode))
                {
                    parent.setBackgroundColor(0xff00ff00);
                    password.setText("4444");
                }
                else
                {
                    parent.setBackgroundColor(0xffff0000);
                    parent.setBackgroundColor(Color.RED);
                    parent.setBackgroundColor(Color.WHITE);

                }
                mdp = "";
            }



        }

    }
}