package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);

        //1
        SurfaceDessin s = new SurfaceDessin(this);

        //2
        s.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //3
        s.setBackgroundResource(R.drawable.carte);
        parent.addView(s);

        //1 gestion des evenement
        Ecouteur ec = new Ecouteur();

        //2
        s.setOnTouchListener(ec);

//        parent.onTouchEvent(MotionEvent ev)
    }

    //3
    private class Ecouteur implements View.OnTouchListener
    {
        @Override
        public boolean onTouch(View source, MotionEvent motionEvent)
        {
            motionEvent.getX();
            motionEvent.getY();
            motionEvent.getAction();

            if(motionEvent.getAction())
        }
    }

    private class SurfaceDessin extends View
    {

        Paint crayonRouge;
//
        public SurfaceDessin(Context context) {
            super(context);
            crayonRouge = new Paint(Paint.ANTI_ALIAS_FLAG);
            crayonRouge.setColor(Color.RED);


        }



        //methode ou on va dessiner
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(70, 70, 70, 70, crayonRouge);

        }


    }
}