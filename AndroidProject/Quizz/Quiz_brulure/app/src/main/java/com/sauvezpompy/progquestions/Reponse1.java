package com.sauvezpompy.progquestions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class Reponse1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse1);

        //appel du score de l'activité précédente
        Intent i = getIntent();
        Bundle b = i.getExtras();
        score1 =(String) b.get("msgScore");

        //vidéo
        VideoView videoView = findViewById(R.id.vidrep);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.brulure_rep;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        //controle de la vidéo
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        score = Integer.parseInt(getScore1());
        //MaJ du score
        TextView afficheScore=(TextView)findViewById(R.id.idScore);
        String affichage = "Score : " + String.valueOf(score);
        afficheScore.setText(affichage);



    }
    @Override
    public void onBackPressed(){
        Intent i = new Intent (this, Fin.class);
        startActivity(i);
    }

    private String score1;
    public String getScore1(){
        return score1;
    }

    private static int score;

   public void modifScore(View view){
       TextView afficheScore=(TextView)findViewById(R.id.idScore);
       String affichage = "Score : " + String.valueOf(score);
       afficheScore.setText(affichage);
   }
    public void boutonRep1(View view){
        Button myButton=(Button)findViewById(R.id.bt4);
        myButton.setBackgroundColor(Color.GRAY);

        //création de l'activité suivante
        Intent activité2 = new Intent (this, Question2.class);

        //enregistrement du score dans msgScore pour pouvoir le passer a l'activité suivante
        String msgScore = String.valueOf(score);
        activité2.putExtra("msgScore", msgScore);

        //appel de l'activité suivante
        startActivity(activité2) ;
    }
}
