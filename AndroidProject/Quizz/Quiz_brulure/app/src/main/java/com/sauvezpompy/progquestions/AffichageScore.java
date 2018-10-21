package com.sauvezpompy.progquestions;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AffichageScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_score);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        score =(String) b.get("msgScore");

        TextView afficheScore=(TextView)findViewById(R.id.idScore);
        String affichage = String.valueOf(score);
        afficheScore.setText(affichage);
    }
    private String score;
    @Override
    public void onBackPressed(){
        Intent i = new Intent (this, Fin.class);
        startActivity(i);
    }
    public void retourMenu(View view){
        Button myButton=(Button)findViewById(R.id.button);
        myButton.setBackgroundColor(Color.GRAY);

        //création de l'activité suivante
        Intent menu = new Intent (this, Fin.class);

        //appel de l'activité suivante
        startActivity(menu) ;
    }
}

