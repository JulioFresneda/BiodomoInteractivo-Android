package adrijuanejulio.com.biodomointeractivo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ExploraActivity extends AppCompatActivity {

    private Button amaButton;
    private Button madButton;
    private Button ipButton;

    static protected int zone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explora);

        amaButton = findViewById(R.id.amazonia_button);
        madButton = findViewById(R.id.mad_button);
        ipButton = findViewById(R.id.ip_button);

        setAmaButton();
        setMadButton();
        setIpButton();

    }



    /**
     * Initializes the Amazonia button and its listener.
     */
    private void setAmaButton() {
       amaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchAmaActivity();
            }

        });
    }

    /* LAunch Amazonia activity*/
    private void launchAmaActivity(){
        zone = 0;
        Intent intent = new Intent(this, ExploraViewActivity.class);
        startActivity(intent);
    }


    /**
     * Initializes the Madagascar button and its listener.
     */
    private void setMadButton() {
        madButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchMadActivity();
            }

        });
    }

    /* LAunch madagascar activity*/
    private void launchMadActivity(){
        zone = 1;
        Intent intent = new Intent(this, ExploraViewActivity.class);
        startActivity(intent);
    }

    /**
     * Initializes the indopacifico button and its listener.
     */
    private void setIpButton() {
        madButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchIpActivity();
            }

        });
    }

    /* LAunch madagascar activity*/
    private void launchIpActivity(){
        zone = 2;
        Intent intent = new Intent(this, ExploraViewActivity.class);
        startActivity(intent);
    }
}
