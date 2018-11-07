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

    private int zoneSelected;
    private ArrayList<Integer> amazonas;
    private ArrayList<Integer> madagascar;

    private ArrayList<Integer> species;

    private ArrayList<String> amazonasTexts;
    private ArrayList<String> madagascarTexts;

    private ArrayList<String> speciesTexts;

    Button left, right;
    ImageView imageView;
    TextView textView;

    private int position;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explora_view);

        position = 0;

        left = findViewById(R.id.left);
        right = findViewById(R.id.right);

        imageView = findViewById(R.id.specieImage);
        textView = findViewById(R.id.animalDescription);

        zoneSelected = ExploraActivity.zone;

        amazonas = new ArrayList<>();
        madagascar = new ArrayList<>();
        species = new ArrayList<>();

        amazonas.add(R.drawable.ama_a_0);
        amazonas.add(R.drawable.ama_v_0);

        madagascar.add(R.drawable.mad_a_0);
        madagascar.add(R.drawable.mad_v_0);


        amazonasTexts = new ArrayList<>();
        madagascarTexts = new ArrayList<>();
        speciesTexts = new ArrayList<>();


        amazonasTexts.add(getResources().getString(R.string.ama_a_0_text));
        amazonasTexts.add(getResources().getString(R.string.ama_v_0_text));

        madagascarTexts.add(getResources().getString(R.string.mad_a_0_text));
        madagascarTexts.add(getResources().getString(R.string.mad_v_0_text));


        if( zoneSelected == 0 ){
            species.addAll(amazonas);
            speciesTexts.addAll(amazonasTexts);
        }
        else if( zoneSelected == 1 ) {
            species.addAll(madagascar);
            speciesTexts.addAll(madagascarTexts);
        }

        imageView.setImageResource(species.get(position));
        textView.setText(speciesTexts.get(position));

        right.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(position < species.size() -1) {
                    position++;

                    int id = species.get(position);

                    imageView.setImageResource(id);
                    textView.setText(speciesTexts.get(position));

                }
            }

        });


        left.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(position > 0 ) {
                    position--;

                    int id = species.get(position);

                    imageView.setImageResource(id);
                    textView.setText(speciesTexts.get(position));
                }
            }

        });

    }
}
