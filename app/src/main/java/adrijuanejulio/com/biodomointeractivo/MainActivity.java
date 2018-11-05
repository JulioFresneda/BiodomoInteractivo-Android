package adrijuanejulio.com.biodomointeractivo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends Activity {


    private Button exploraButton = findViewById(R.id.exploraButton);
    private Button nfcButton = findViewById(R.id.nfcButton);
    private Button qrButton = findViewById(R.id.qrButton);
    private Button preciosButton = findViewById(R.id.preciosButton);
    private Button redesButton = findViewById(R.id.redesButton);
    private Button mapaButton = findViewById(R.id.mapaButton);



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
