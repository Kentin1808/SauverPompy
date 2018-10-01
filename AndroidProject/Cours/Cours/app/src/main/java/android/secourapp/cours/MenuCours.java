package android.secourapp.cours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuCours extends AppCompatActivity {
    private Button button_brulure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_brulure = (Button)findViewById(R.id.button);
        button_brulure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPageBrulure();
            }
        });
    }

    public void openPageBrulure(){
        Intent intent = new Intent(this, PageBrulure.class);
        startActivity(intent);
    }

}
