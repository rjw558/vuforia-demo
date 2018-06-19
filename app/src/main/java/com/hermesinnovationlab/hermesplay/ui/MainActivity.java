package com.hermesinnovationlab.hermesplay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hermesinnovationlab.hermesplay.R;
import com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode.Hermes2DBarcode;
import com.hermesinnovationlab.hermesplay.parsers.hermes2dbarcode.Hermes2DBarcodeParser;

public class MainActivity extends Activity {
    private static final String LOGTAG = "AboutScreen";

    private Button startButton;
    private Button crossButton;
    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_screen);
        appContext = this;
        startButton = (Button) findViewById(R.id.hermesArButton);
        crossButton = (Button) findViewById(R.id.crossButton);
        setupOnClick();
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        String scanContent = scanningResult.getContents().toString();
        Log.i(LOGTAG, "XXX: " + scanContent);
        String contentId = getContentIdFromScanContent(scanContent);
        // Here we would call the HermesPlay API to get video.
        startARActivity(contentId);
    }

    // Starts the chosen activity
    private void startARActivity(String barcode) {
        Intent i = new Intent(appContext, VideoPlaybackActivity.class);
        i.putExtra("CONTENT_ID", barcode);
        startActivity(i);
    }

    //Scan for a barcode.
    private void startBarcodeScanActivity() {
        IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
        scanIntegrator.setPrompt("Scan the barcode on the label");
        scanIntegrator.setBeepEnabled(true);
        scanIntegrator.setOrientationLocked(false);
        scanIntegrator.setBarcodeImageEnabled(true);
        scanIntegrator.initiateScan();
    }

    private void setupOnClick(){
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startBarcodeScanActivity();
            }
        });
        crossButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startBarcodeScanActivity();
            }
        });
    }

    private String getContentIdFromScanContent(String scanContent) {
        Log.v("Barcode: ", scanContent.toString());
        if (Hermes2DBarcodeParser.isHermes2DBarcode(scanContent)) {
            Hermes2DBarcode barcode = Hermes2DBarcodeParser.parseBarcodeData(scanContent);
            Log.v("2D BARCODE: ", barcode.getMultimediaContent().getContentUri1());
            return barcode.getMultimediaContent().getContentUri1();
        } else {
            return scanContent;
        }
    }

}
