package com.sauvezpompy.progquestions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import com.sauvezpompy.progquestions.Question1;

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Button myButton = (Button) findViewById(R.id.bt1);
        Button myButton2 = (Button) findViewById(R.id.bt2);
        Button myButton3 = (Button) findViewById(R.id.bt3);
        Button myButton4 = (Button) findViewById(R.id.bt4);


        //appel du score de l'activité précédente
        Intent i = getIntent();
        Bundle b = i.getExtras();
        score1 = (String) b.get("msgScore");

        score = Integer.parseInt(getScore1());
        //MaJ du score
        TextView afficheScore = (TextView) findViewById(R.id.idScore);
        String affichage = "Score : " + String.valueOf(score);
        afficheScore.setText(affichage);

    }

    public void modifScore(View view) {
        //mettre a jour le score
        TextView textView = (TextView) findViewById(R.id.idScore);
        String score1 = "Score : " + String.valueOf(score);
        textView.setText(score1);
    }

    public void bonneReponse(View view) {
        Button myButton2 = (Button) findViewById(R.id.bt2);
        Button myButton1 = (Button) findViewById(R.id.bt1);
        Button myButton3 = (Button) findViewById(R.id.bt3);
        //calcule des points: bonne rep du premier cout = 5pt, 2eme coup = 3 pt, 3eme cout = 1 pt
        if (myButton2.isClickable() || myButton1.isClickable() || myButton3.isClickable()) {
            score = score + 5;
        }
        //laisser le score a 0 même si bonne réponse du 4eme coup (normalement -1)
        else {
            score = score + 6;
        }

        Intent intent = new Intent(this, Reponse3.class);

        //enregistrement du score dans msgScore pour pouvoir le passer a l'activité suivante
        String msgScore = String.valueOf(score);
        intent.putExtra("msgScore", msgScore);

        //appel de l'activité suivante
        startActivity(intent);

        //mettre la bonne réponse en vert quand on click dessus
        Button myButton = (Button) findViewById(R.id.bt4);
        myButton.setBackgroundColor(Color.GREEN);

        //MaJ du score
        modifScore(view);

    }

    public void mauvaiseRep2(View view) {
        Button myButton = (Button) findViewById(R.id.bt2);
        myButton.setBackgroundColor(Color.RED);
        myButton.setClickable(false);
        score = score - 2;

    }


    public void mauvaiseRep1(View view) {
        Button myButton = (Button) findViewById(R.id.bt1);
        myButton.setBackgroundColor(Color.RED);
        myButton.setClickable(false);
        score = score - 2;

    }

    public void mauvaiseRep3(View view) {
        Button myButton = (Button) findViewById(R.id.bt3);
        myButton.setBackgroundColor(Color.RED);
        myButton.setClickable(false);
        score = score - 2;

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Fin.class);
        startActivity(i);
    }

    private String score1;

    public String getScore1() {
        return score1;
    }

    private static int score;
}