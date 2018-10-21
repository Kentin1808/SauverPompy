package com.sauvezpompy.progquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);


    }
    public void recommencer(View view){
        Intent i = new Intent(this, Question1.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed(){
        //do nothing
    }
}
