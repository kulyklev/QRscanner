package com.example.admin.qrscanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.TextView;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public class ScanResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        textView = (TextView) findViewById(R.id.txtResult);
        final String barcode = (String) getIntent().getExtras().getSerializable("barcode");

        if (Patterns.WEB_URL.matcher(barcode).matches()){
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setMessage("Do you want to open " + barcode); // сообщение
            ad.setPositiveButton("YES", new OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    openURL(barcode);
                }
            });

            ad.setNegativeButton("NO", new OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    textView.setText(barcode);
                }
            });

            ad.show();
        }
        else
            textView.setText(barcode);
    }

    private void openURL(String url){
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
