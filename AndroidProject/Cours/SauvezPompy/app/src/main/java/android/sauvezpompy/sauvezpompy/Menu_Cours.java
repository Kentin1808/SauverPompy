package android.sauvezpompy.sauvezpompy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Cours extends AppCompatActivity {

    private Button Button_Brulures;
    private Button Button_CoupDeChaleur;
    private Button Button_AVC;
    private Button Button_ArretCariaque;
    private Button Button_PCI;
    private Button Button_AVP;
    private Button Button_Hemorragie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cours);

        Button_Brulures = (Button)findViewById(R.id.Button_Brulures);
        Button_Brulures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPageBrulure();
            }
        });
    }

    public void openPageBrulure(){
        Intent intent = new Intent(this, Cours_Brulures.class);
        startActivity(intent);
    }

}
