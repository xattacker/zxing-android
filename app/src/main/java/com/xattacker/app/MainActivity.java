package com.xattacker.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity
{
    private final static int REQUEST_CODE = 555;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        for (int r : grantResults)
        {
            if (r == PackageManager.PERMISSION_DENIED)
            {
                return;
            }
        }

        callScan();
    }

    @Override
    protected void onActivityResult(int aRequestCode, int aResultCode, Intent aIntent)
    {
        super.onActivityResult(aRequestCode, aResultCode, aIntent);

        if (aResultCode != RESULT_OK)
        {
            return;
        }


        if (aRequestCode == REQUEST_CODE)
        {
            // get 2d code scan result
            String format = aIntent.getStringExtra(Intents.Scan.RESULT_FORMAT);
            if (format != null && format.equals(BarcodeFormat.QR_CODE.toString()))
            {
                String content = aIntent.getStringExtra(Intents.Scan.RESULT);
                android.util.Log.i(MainActivity.class.getName(), content);
                Toast.makeText(this, content, Toast.LENGTH_LONG).show();
            }
        }
    }

    // on button click
    public void onClick(View aView)
    {
        callScan();
    }

    private void callScan()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions
            (
            this,
            new String[]{Manifest.permission.CAMERA},
            1
            );
        }
        else
        {
            // TWO_D_CODE formats includes "QR_CODE", "DATA_MATRIX", "PDF_417", "AZTEC"
            CaptureActivity.showActivity(this, Intents.Scan.TWO_D_CODE_FORMATS, REQUEST_CODE);
        }
    }
}
