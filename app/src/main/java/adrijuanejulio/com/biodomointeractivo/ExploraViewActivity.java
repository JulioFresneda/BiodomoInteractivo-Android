package adrijuanejulio.com.biodomointeractivo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.Collections;

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

    private ArrayList<Integer> shuffleIndices;

    Button leftButton, rightButton;
    FloatingActionButton floatingQRButton;

    TextView titleTextView;
    ImageView imageView;
    TextView textView;

    private int position;

    private Drawable leftButtonDrawable, rightButtonDrawable;


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

        shuffleIndices = new ArrayList<>();


        floatingQRButton = findViewById(R.id.floatingQRButton);
        //Set up the qr button
        setQrButton();


        // INSERT SPECIES
        insertSpecies();


        /* FIN SIMULACION BASE DE DATOS */

        position = 0;

        leftButton = findViewById(R.id.left);
        rightButton = findViewById(R.id.right);

        titleTextView = findViewById(R.id.title_image);
        imageView = findViewById(R.id.specieImage);
        textView = findViewById(R.id.animalDescription);

        leftButtonDrawable = getDrawable(R.drawable.button_left);
        rightButtonDrawable = getDrawable(R.drawable.button_right);






        // Insertamos datos según la zona

        if (getIntent().getStringExtra("zone") != null) {
            Log.e("RECIBIENDO INTENT", " ---------------> Viene de la pantalla de zonas");
            zoneSelected = getIntent().getStringExtra("zone");

            titles = new ArrayList<>();
            species = new ArrayList<>();
            speciesTexts = new ArrayList<>();

            ImageView topscreen;
            ImageView bgText;

            switch (zoneSelected) {


                case "0":
                    titles.addAll(amazonasTitles);
                    species.addAll(amazonas);
                    speciesTexts.addAll(amazonasTexts);

                    topscreen = findViewById(R.id.bg_title_explora);
                    topscreen.setImageResource(R.drawable.explora_ama_topscreen);

                    bgText = findViewById(R.id.bg_text_explora);
                    bgText.setImageResource(R.drawable.explora_amaz_button);

                    leftButtonDrawable = getDrawable(R.drawable.explora_button_left_ama);
                    rightButtonDrawable = getDrawable(R.drawable.explora_button_right_ama);

                    break;
                case "1":
                    titles.addAll(madagascarTitles);
                    species.addAll(madagascar);
                    speciesTexts.addAll(madagascarTexts);

                    topscreen = findViewById(R.id.bg_title_explora);
                    topscreen.setImageResource(R.drawable.explora_mad_topscreen);

                    bgText = findViewById(R.id.bg_text_explora);
                    bgText.setImageResource(R.drawable.explora_mad_button);

                    leftButtonDrawable = getDrawable(R.drawable.explora_button_left_mad);
                    rightButtonDrawable = getDrawable(R.drawable.explora_button_right_mad);

                    break;
                case "2":
                    titles.addAll(indoPacificoTitles);
                    species.addAll(indoPacifico);
                    speciesTexts.addAll(indoPacificoTexts);

                    topscreen = findViewById(R.id.bg_title_explora);
                    topscreen.setImageResource(R.drawable.explora_ip_topscreen);

                    bgText = findViewById(R.id.bg_text_explora);
                    bgText.setImageResource(R.drawable.explora_ip_button);

                    leftButtonDrawable = getDrawable(R.drawable.explora_button_left_ip);
                    rightButtonDrawable = getDrawable(R.drawable.explora_button_right_ip);

                    break;
            }

            for( int i=0; i<species.size(); i++ )
            {
                shuffleIndices.add(i);
            }

            Collections.shuffle(shuffleIndices);



            titleTextView.setText(titles.get(shuffleIndices.get(position)));
            imageView.setImageResource(species.get(shuffleIndices.get(position)));
            textView.setText(speciesTexts.get(shuffleIndices.get(position)));

            rightButton.setBackground(rightButtonDrawable);
            leftButton.setBackgroundResource(R.drawable.button_left_right_off);



        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(position < species.size() -1) {
                    position++;

                    int id = species.get(shuffleIndices.get(position));

                    titleTextView.setText(titles.get(shuffleIndices.get(position)));

                    imageView.setImageResource(id);

                    textView.setText(speciesTexts.get(shuffleIndices.get(position)));

                    if( position == species.size()-1 ) rightButton.setBackgroundResource(R.drawable.button_left_right_off);
                    if( position == 1 ) leftButton.setBackground(leftButtonDrawable);

                }
            }

        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(position > 0 ) {
                    position--;

                    int id = species.get(shuffleIndices.get(position));

                    titleTextView.setText(titles.get(shuffleIndices.get(position)));
                    imageView.setImageResource(id);
                    textView.setText(speciesTexts.get(shuffleIndices.get(position)));

                    if( position == 0 ) leftButton.setBackgroundResource(R.drawable.button_left_right_off);


                    if(position == species.size()-2 ) rightButton.setBackground(rightButtonDrawable);
                }

            }

            });


        } else if (getIntent().getStringExtra("id") != null) {
            Log.e("RECIBIENDO INTENT", " ---------------> Viene de la pantalla del lector QR");
            String id = getIntent().getStringExtra("id");

            rightButton.setVisibility(View.INVISIBLE);
            leftButton.setVisibility(View.INVISIBLE);

            int idTitle = getResources().getIdentifier(id + "_title", "string", getPackageName());
            int idImage = getResources().getIdentifier(id, "drawable", getPackageName());
            int idDesc = getResources().getIdentifier(id + "_text", "string", getPackageName());

            Log.e("ids", idTitle + " " + idImage + " " + idDesc);

            titleTextView.setText(idTitle);
            imageView.setImageResource(idImage);
            textView.setText(idDesc);
        } else if (getIntent().getStringExtra("zone_NFC") != null) {

            int id = Integer.parseInt(getIntent().getStringExtra("zone_NFC"));
            Log.e("RECIBIENDO INTENT", " ---------------> Viene de la pantalla del lector NFC + " + id);
            rightButton.setVisibility(View.INVISIBLE);
            leftButton.setVisibility(View.INVISIBLE);

            switch (id) {
                case 0:
                    titleTextView.setText(R.string.zone_amazonia_title);
                    imageView.setImageResource(R.drawable.explora_amaz_button);
                    textView.setText(R.string.zone_amazonia_desc);
                    break;
                case 1:
                    titleTextView.setText(R.string.zone_madagascar_title);
                    imageView.setImageResource(R.drawable.explora_mad_button);
                    textView.setText(R.string.zone_madagascar_desc);
                    break;
                case 2:
                    titleTextView.setText(R.string.zone_ip_title);
                    imageView.setImageResource(R.drawable.explora_ip_button);
                    textView.setText(R.string.zone_ip_desc);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Zona no válida", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(getApplicationContext(), "No es posible abrir Explora View", Toast.LENGTH_SHORT).show();
        }



    }





    /**
     * Initializes the qr button and its listener. When the button is pressed, a qr recognition is enabled.
     */
    private void setQrButton() {
        // gain reference to qr button
        final Activity activity = this;

        floatingQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Escaneando QR");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }

        });
    }

    /* Returns results of call intents (use of QR)*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Has cancelado el escaneo", Toast.LENGTH_LONG).show();
            } else {
//
                String contentQR = result.getContents();

                if (contentQR.contains("http")) {
                    Uri web = Uri.parse(contentQR);
                    Intent gotoWeb = new Intent(Intent.ACTION_VIEW, web);
                    startActivity(gotoWeb);
                } else {
                    // Low cifrate
                    if (contentQR.toLowerCase().contains("biodomointeractivo")) {
                        String id = contentQR.substring(contentQR.indexOf(":") + 1);

                        Intent intent = new Intent(this, ExploraViewActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }











    private void insertSpecies()
    {
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

        //titulos madagascar
        madagascarTitles.add(getResources().getString(R.string.mad_a_0_title));
        madagascarTitles.add(getResources().getString(R.string.mad_a_1_title));
        madagascarTitles.add(getResources().getString(R.string.mad_a_2_title));

        madagascarTitles.add(getResources().getString(R.string.mad_v_0_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_1_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_2_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_3_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_4_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_5_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_6_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_7_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_8_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_9_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_10_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_11_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_12_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_13_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_14_title));
        madagascarTitles.add(getResources().getString(R.string.mad_v_15_title));



        //titulos indopacifico
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_0_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_1_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_2_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_3_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_4_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_5_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_6_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_7_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_8_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_9_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_10_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_11_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_12_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_13_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_14_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_a_15_title));



        indoPacificoTitles.add(getResources().getString(R.string.ip_v_0_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_1_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_2_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_3_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_4_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_5_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_6_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_7_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_8_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_9_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_10_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_11_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_12_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_13_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_14_title));
        indoPacificoTitles.add(getResources().getString(R.string.ip_v_15_title));



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
        madagascar.add(R.drawable.mad_v_1);
        madagascar.add(R.drawable.mad_v_2);
        madagascar.add(R.drawable.mad_v_3);
        madagascar.add(R.drawable.mad_v_4);
        madagascar.add(R.drawable.mad_v_5);
        madagascar.add(R.drawable.mad_v_6);
        madagascar.add(R.drawable.mad_v_7);
        madagascar.add(R.drawable.mad_v_8);
        madagascar.add(R.drawable.mad_v_9);
        madagascar.add(R.drawable.mad_v_10);
        madagascar.add(R.drawable.mad_v_11);
        madagascar.add(R.drawable.mad_v_12);
        madagascar.add(R.drawable.mad_v_13);
        madagascar.add(R.drawable.mad_v_14);
        madagascar.add(R.drawable.mad_v_15);


        //imagenes indo pacifico
        indoPacifico.add(R.drawable.ip_a_0);
        indoPacifico.add(R.drawable.ip_a_1);
        indoPacifico.add(R.drawable.ip_a_2);
        indoPacifico.add(R.drawable.ip_a_3);
        indoPacifico.add(R.drawable.ip_a_4);
        indoPacifico.add(R.drawable.ip_a_5);
        indoPacifico.add(R.drawable.ip_a_6);
        indoPacifico.add(R.drawable.ip_a_7);
        indoPacifico.add(R.drawable.ip_a_8);
        indoPacifico.add(R.drawable.ip_a_9);
        indoPacifico.add(R.drawable.ip_a_10);
        indoPacifico.add(R.drawable.ip_a_11);
        indoPacifico.add(R.drawable.ip_a_12);
        indoPacifico.add(R.drawable.ip_a_13);
        indoPacifico.add(R.drawable.ip_a_14);
        indoPacifico.add(R.drawable.ip_a_15);



        indoPacifico.add(R.drawable.ip_v_0);
        indoPacifico.add(R.drawable.ip_v_1);
        indoPacifico.add(R.drawable.ip_v_2);
        indoPacifico.add(R.drawable.ip_v_3);
        indoPacifico.add(R.drawable.ip_v_4);
        indoPacifico.add(R.drawable.ip_v_5);
        indoPacifico.add(R.drawable.ip_v_6);
        indoPacifico.add(R.drawable.ip_v_7);
        indoPacifico.add(R.drawable.ip_v_8);
        indoPacifico.add(R.drawable.ip_v_9);
        indoPacifico.add(R.drawable.ip_v_10);
        indoPacifico.add(R.drawable.ip_v_11);
        indoPacifico.add(R.drawable.ip_v_12);
        indoPacifico.add(R.drawable.ip_v_13);
        indoPacifico.add(R.drawable.ip_v_14);
        indoPacifico.add(R.drawable.ip_v_15);


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


        // inserts descripciones madagascar
        madagascarTexts.add(getResources().getString(R.string.mad_a_0_text));
        madagascarTexts.add(getResources().getString(R.string.mad_a_1_text));
        madagascarTexts.add(getResources().getString(R.string.mad_a_2_text));


        madagascarTexts.add(getResources().getString(R.string.mad_v_0_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_1_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_2_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_3_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_4_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_5_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_6_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_7_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_8_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_9_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_10_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_11_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_12_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_13_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_14_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_15_text));

        // descripciones indo pacifico

        indoPacificoTexts.add(getResources().getString(R.string.ip_a_0_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_1_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_2_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_3_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_4_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_5_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_6_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_7_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_8_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_9_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_10_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_11_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_12_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_13_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_14_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_a_15_text));


        indoPacificoTexts.add(getResources().getString(R.string.ip_v_0_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_1_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_2_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_3_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_4_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_5_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_6_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_7_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_8_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_9_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_10_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_11_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_12_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_13_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_14_text));
        indoPacificoTexts.add(getResources().getString(R.string.ip_v_15_text));
    }


}
