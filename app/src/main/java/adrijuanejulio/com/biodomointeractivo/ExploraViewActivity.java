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


    /**
     * Simulate of a Database of animals and vegetables of Biodomo
     */
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
        amazonasTitles.add(getResources().getString(R.string.ama_a_1_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_2_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_3_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_4_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_5_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_6_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_7_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_8_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_9_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_10_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_11_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_12_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_13_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_14_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_15_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_16_title));
        amazonasTitles.add(getResources().getString(R.string.ama_a_17_title));


        amazonasTitles.add(getResources().getString(R.string.ama_v_0_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_1_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_2_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_3_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_4_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_5_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_6_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_7_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_8_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_9_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_10_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_11_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_12_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_13_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_14_title));
        amazonasTitles.add(getResources().getString(R.string.ama_v_15_title));





        amazonasTitles.add(getResources().getString(R.string.ama_v_0_title));



        //titulos madagascar
        madagascarTitles.add(getResources().getString(R.string.mad_a_0_title));
        madagascarTitles.add(getResources().getString(R.string.mad_a_1_title));
        madagascarTitles.add(getResources().getString(R.string.mad_a_2_title));



        madagascarTitles.add(getResources().getString(R.string.mad_v_0_title));

        /*//titulos indopacifico
        madagascarTitles.add(getResources().getString(R.string.mad_a_0_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_0_title));*/

        // INSERTS ID Imagenes
        // imagenes amazonas
        amazonas.add(R.drawable.ama_a_0);
        amazonas.add(R.drawable.ama_a_1);
        amazonas.add(R.drawable.ama_a_2);
        amazonas.add(R.drawable.ama_a_3);
        amazonas.add(R.drawable.ama_a_4);
        amazonas.add(R.drawable.ama_a_5);
        amazonas.add(R.drawable.ama_a_6);
        amazonas.add(R.drawable.ama_a_7);
        amazonas.add(R.drawable.ama_a_8);
        amazonas.add(R.drawable.ama_a_9);
        amazonas.add(R.drawable.ama_a_10);
        amazonas.add(R.drawable.ama_a_11);
        amazonas.add(R.drawable.ama_a_12);
        amazonas.add(R.drawable.ama_a_13);
        amazonas.add(R.drawable.ama_a_14);
        amazonas.add(R.drawable.ama_a_15);
        amazonas.add(R.drawable.ama_a_16);
        amazonas.add(R.drawable.ama_a_17);


        amazonas.add(R.drawable.ama_v_0);
        amazonas.add(R.drawable.ama_v_1);
        amazonas.add(R.drawable.ama_v_2);
        amazonas.add(R.drawable.ama_v_3);
        amazonas.add(R.drawable.ama_v_4);
        amazonas.add(R.drawable.ama_v_5);
        amazonas.add(R.drawable.ama_v_6);
        amazonas.add(R.drawable.ama_v_7);
        amazonas.add(R.drawable.ama_v_8);
        amazonas.add(R.drawable.ama_v_9);
        amazonas.add(R.drawable.ama_v_10);
        amazonas.add(R.drawable.ama_v_11);
        amazonas.add(R.drawable.ama_v_12);
        amazonas.add(R.drawable.ama_v_13);
        amazonas.add(R.drawable.ama_v_14);
        amazonas.add(R.drawable.ama_v_15);






        //imagenes madagascar
        madagascar.add(R.drawable.mad_a_0);
        madagascar.add(R.drawable.mad_a_1);
        madagascar.add(R.drawable.mad_a_2);



        madagascar.add(R.drawable.mad_v_0);

        /*//imagenes indo pacifico
        madagascar.add(R.drawable.mad_a_0);
        madagascar.add(R.drawable.mad_v_0);*/

        // INSERTS id descripciones
        // inserts descripciones amazonas
        amazonasTexts.add(getResources().getString(R.string.ama_a_0_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_1_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_2_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_3_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_4_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_5_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_6_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_7_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_8_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_9_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_10_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_11_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_12_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_13_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_14_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_15_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_16_text));
        amazonasTexts.add(getResources().getString(R.string.ama_a_17_text));



        amazonasTexts.add(getResources().getString(R.string.ama_v_0_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_1_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_2_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_3_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_4_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_5_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_6_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_7_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_8_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_9_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_10_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_11_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_12_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_13_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_14_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_15_text));










        amazonasTexts.add(getResources().getString(R.string.ama_v_0_text));

        // inserts descripciones madagascar
        madagascarTexts.add(getResources().getString(R.string.mad_a_0_text));
        madagascarTexts.add(getResources().getString(R.string.mad_a_1_text));
        madagascarTexts.add(getResources().getString(R.string.mad_a_2_text));


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
            String id = getIntent().getStringExtra("id");

            leftButton.setEnabled(false);
            rightButton.setEnabled(false);
            String title = id + "_title";
            String image = id;
            String desc = id + "_text";
            int idtitle = getResources().getIdentifier(title,null,null);
            int idimage = getResources().getIdentifier(image,null,null);
            int iddesc = getResources().getIdentifier(desc,null,null);



            Log.e("RECIBIENDO INTENT", " ---------------> Viene de QR O NFC");



            try{
                titleTextView.setText(idtitle);
            }
            catch(Exception e){
                Log.e("Titulo incorrecto","Titulo incorrecto");
            }

            try{
                imageView.setImageResource(idimage);
            }
            catch(Exception e){
                Log.e("Imagen incorrecta","Imagen incorrecta");
            }

            try{
                textView.setText(iddesc);
            }
            catch(Exception e){
                Log.e("Desc incorrecta","Desc incorrecta");
            }
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
