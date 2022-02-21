package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
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
        SurfaceDessin surf = new SurfaceDessin(this);

        //2
        surf.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //3
        surf.setBackgroundColor(Color.RED);
        parent.addView(surf);
        //4

    }

    public int dpToPx(int dp) {
        float density = this.getResources().getDisplayMetrics().density;
        return Math.round( dp * density);
    }
    private class SurfaceDessin extends View
    {

        Paint crayonVert;
        Paint crayonJaune;
        Paint crayonbleu;
        public SurfaceDessin(Context context) {
            super(context);
            crayonVert = new Paint(Paint.ANTI_ALIAS_FLAG);
            crayonVert.setColor(Color.GREEN);
            crayonJaune = new Paint(Paint.ANTI_ALIAS_FLAG);
            crayonJaune.setStyle(Paint.Style.STROKE);
            crayonJaune.setStrokeWidth(5);
            crayonJaune.setColor(Color.YELLOW);
            crayonbleu = new Paint(Paint.ANTI_ALIAS_FLAG);
            crayonbleu.setColor(Color.BLUE);

        }


        //methode ou on va dessiner
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(
                    70, 70,
                    60,
                    crayonVert);

            canvas.drawCircle(
                    200, 70,
                    70,
                    crayonJaune);

            canvas.drawArc(
                    260,60,360,160,0,120,true,crayonJaune);
            canvas.drawArc(
                    260,60,360,160,120,120,true,crayonVert);
            canvas.drawArc(
                    260,60,360,160,0,360,true,crayonbleu);
        }
    }
}