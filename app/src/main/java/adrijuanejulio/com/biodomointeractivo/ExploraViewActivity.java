package adrijuanejulio.com.biodomointeractivo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExploraViewActivity extends AppCompatActivity {

    private String zoneSelected;

    private ArrayList<String> amazonasTitles;
    private ArrayList<String> madagascarTitles;
    private ArrayList<String> indoPacificoTitles;

    private ArrayList<Integer> amazonas;
    private ArrayList<Integer> madagascar;
    private ArrayList<Integer> indoPacifico;

    private ArrayList<String> amazonasTexts;
    private ArrayList<String> madagascarTexts;
    private ArrayList<String> indoPacificoTexts;

    private ArrayList<String> titles;
    private ArrayList<Integer> species;
    private ArrayList<String> speciesTexts;

    Button leftButton, rightButton;

    TextView titleTextView;
    ImageView imageView;
    TextView textView;

    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explora_view);

        /* INICIO SIMULACION BASE DE DATOS */
        amazonasTitles = new ArrayList<>();
        madagascarTitles = new ArrayList<>();
        indoPacificoTitles = new ArrayList<>();

        amazonas = new ArrayList<>();
        madagascar = new ArrayList<>();
        indoPacifico = new ArrayList<>();

        amazonasTexts = new ArrayList<>();
        madagascarTexts = new ArrayList<>();
        indoPacificoTexts = new ArrayList<>();

        // INSERTS ID titulos
        // titulos amazonas
        amazonasTitles.add(getResources().getString(R.string.ama_a_0_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_0_title));

        //titulos madagascar
        madagascarTitles.add(getResources().getString(R.string.mad_a_0_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_0_title));

        /*//titulos indopacifico
        madagascarTitles.add(getResources().getString(R.string.mad_a_0_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_0_title));*/

        // INSERTS ID Imagenes
        // imagenes amazonas
        amazonas.add(R.drawable.ama_a_0);
        amazonas.add(R.drawable.ama_v_0);

        //imagenes madagascar
        madagascar.add(R.drawable.mad_a_0);
        madagascar.add(R.drawable.mad_v_0);

        /*//imagenes indo pacifico
        madagascar.add(R.drawable.mad_a_0);
        madagascar.add(R.drawable.mad_v_0);*/

        // INSERTS id descripciones
        // inserts descripciones amazonas
        amazonasTexts.add(getResources().getString(R.string.ama_a_0_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_0_text));

        // inserts descripciones madagascar
        madagascarTexts.add(getResources().getString(R.string.mad_a_0_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_0_text));

        /*// inserts descripciones indo pacifico
        madagascarTexts.add(getResources().getString(R.string.mad_a_0_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_0_text));*/

        /* FIN SIMULACION BASE DE DATOS */

        position = 0;

        leftButton = findViewById(R.id.left);
        rightButton = findViewById(R.id.right);

        titleTextView = findViewById(R.id.title_image);
        imageView = findViewById(R.id.specieImage);
        textView = findViewById(R.id.animalDescription);

        if (getIntent().getStringExtra("zone") != null) {
            Log.e("RECIBIENDO INTENT", " ---------------> Viene de la pantalla de zonas");
            zoneSelected = getIntent().getStringExtra("zone");

            titles = new ArrayList<>();
            species = new ArrayList<>();
            speciesTexts = new ArrayList<>();

            if (zoneSelected.equals("0")) {
                titles.addAll(amazonasTitles);
                species.addAll(amazonas);
                speciesTexts.addAll(amazonasTexts);
            } else if (zoneSelected.equals("1")) {
                titles.addAll(madagascarTitles);
                species.addAll(madagascar);
                speciesTexts.addAll(madagascarTexts);
            } else if (zoneSelected.equals("2")) {
                titles.addAll(indoPacificoTitles);
                species.addAll(indoPacifico);
                speciesTexts.addAll(indoPacificoTexts);
            }

            titleTextView.setText(titles.get(position));
            imageView.setImageResource(species.get(position));
            textView.setText(speciesTexts.get(position));
        } else {
            Log.e("RECIBIENDO INTENT", " ---------------> Viene de QR O NFC");
            position = 1;

            titleTextView.setText(titles.get(position));
            imageView.setImageResource(species.get(position));
            textView.setText(speciesTexts.get(position));
        }

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(position < species.size() -1) {
                    position++;

                    int id = species.get(position);

                    titleTextView.setText(titles.get(position));
                    imageView.setImageResource(id);
                    textView.setText(speciesTexts.get(position));

                }
            }

        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(position > 0 ) {
                    position--;

                    int id = species.get(position);

                    titleTextView.setText(titles.get(position));
                    imageView.setImageResource(id);
                    textView.setText(speciesTexts.get(position));
                }
            }

        });

    }
}
