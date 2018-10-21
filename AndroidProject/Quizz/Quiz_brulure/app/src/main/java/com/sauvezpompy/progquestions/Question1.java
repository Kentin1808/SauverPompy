package com.sauvezpompy.progquestions;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);


        Button myButton=(Button)findViewById(R.id.bt1);
        Button myButton2=(Button)findViewById(R.id.bt2);
        Button myButton3=(Button)findViewById(R.id.bt3);
        Button myButton4=(Button)findViewById(R.id.bt4);

        //Vidéo
        VideoView videoView = findViewById(R.id.vid);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.brulure;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        //initialiser le score a 0 (meme quand on ferme et relance l'appli)
        if(myButton.getLinksClickable() && myButton2.getLinksClickable() && myButton3.getLinksClickable() && myButton4.getLinksClickable()){
            score = 0;
        }

    }
    private static int score = 0;
    public void modifScore(View view){
        //mettre a jour le score
        TextView textView=(TextView)findViewById(R.id.idScore);
        String score1 = "Score : " + String.valueOf(score);
        textView.setText(score1);
    }


    // quand on appuie sur la bonne réponse
        public void bonneReponse(View view){
            Button myButton2=(Button)findViewById(R.id.bt2);
            Button myButton3=(Button)findViewById(R.id.bt3);
            Button myButton4=(Button)findViewById(R.id.bt4);
            //calcule des points: bonne rep du premier cout = 5pt, 2eme coup = 3 pt, 3eme cout = 1 pt
            if(myButton2.isClickable() ||myButton3.isClickable() || myButton4.isClickable()  ) {
                score = score + 5;
            }
            //laisser le score a 0 même si bonne réponse du 4eme coup (normalement -1)
            else  {
                score = score + 6;
            }

             //création de l'activité suivante
             Intent intent = new Intent (this, Reponse1.class);

            //enregistrement du score dans msgScore pour pouvoir le passer a l'activité suivante
             String msgScore = String.valueOf(score);
             intent.putExtra("msgScore", msgScore);

            //appel de l'activité suivante
            startActivity(intent) ;

             //mettre la bonne réponse en vert quand on click dessus
             Button myButton=(Button)findViewById(R.id.bt1);
             myButton.setBackgroundColor(Color.GREEN);

             //MaJ du score
            modifScore(view);

         }

    // 3 prochaine méthodes = mauvais bouton (je n'ai pas réussi a en créer une unique pour les 3 cas)
    public void mauvaiseRep1 (View view){
        Button myButton=(Button)findViewById(R.id.bt2);
        myButton.setBackgroundColor(Color.RED);
        myButton.setClickable(false);
        score = score-2;

    }


    public void mauvaiseRep2 (View view){
        Button myButton=(Button)findViewById(R.id.bt3);
        myButton.setBackgroundColor(Color.RED);
        myButton.setClickable(false);
        score = score-2;

    }
    public void mauvaiseRep3 (View view){
        Button myButton=(Button)findViewById(R.id.bt4);
        myButton.setBackgroundColor(Color.RED);
        myButton.setClickable(false);
        score = score-2;

    }

@Override
    public void onBackPressed(){
    Intent i = new Intent (this, Fin.class);
    startActivity(i);
}
}
