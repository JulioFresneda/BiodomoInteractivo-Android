package adrijuanejulio.com.biodomointeractivo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends Activity {

    private ImageButton exploraButton = findViewById(R.id.exploraButton);
    private ImageButton nfcButton = findViewById(R.id.nfcButton);
    private ImageButton qrButton = findViewById(R.id.qrButton);
    private ImageButton preciosButton = findViewById(R.id.preciosButton);
    private ImageButton redesButton = findViewById(R.id.redesButton);
    private ImageButton mapaButton = findViewById(R.id.mapaButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Activity activity = this;
        qrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
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
}
