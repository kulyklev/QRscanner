package com.example.admin.qrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScanResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        textView = (TextView) findViewById(R.id.txtResult);
        String barcode = (String) getIntent().getExtras().getSerializable("barcode");
        textView.setText(barcode);
    }
}
