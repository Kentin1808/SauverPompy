package com.sauvezpompy.progquestions;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sauvezpompy.progquestions.Question1;
public class Reponse2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse2);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        score1 =(String) b.get("msgScore");

        score = Integer.parseInt(getScore1());
        //MaJ du score
        TextView afficheScore=(TextView)findViewById(R.id.idScore);
        String affichage = "Score : " + String.valueOf(score);
        afficheScore.setText(affichage);

    }
    private String score1;
    private static int score;

    public String getScore1(){
        return score1;
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent (this, Fin.class);
        startActivity(i);
    }

    public void boutonRep(View view){
        Button myButton=(Button)findViewById(R.id.bt4);
        myButton.setBackgroundColor(Color.GRAY);

        //création de l'activité suivante
        Intent activité2 = new Intent (this, Question3.class);

        //enregistrement du score dans msgScore pour pouvoir le passer a l'activité suivante
        String msgScore = String.valueOf(score);
        activité2.putExtra("msgScore", msgScore);

        //appel de l'activité suivante
        startActivity(activité2) ;
    }

}
