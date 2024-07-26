package org.hritik.aipoweredagriculture;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ProgressDialog dg = new ProgressDialog(this);
        dg.setMessage("Loading map..");
        dg.show();
        new Handler().postDelayed(dg::dismiss,1500);
    }

    public void openForResult(View view) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching results");
        dialog.setMessage("Please wait....");
        dialog.show();
        new Handler().postDelayed(() -> {
            startActivity(new Intent(MapActivity.this,SatelliteActivity.class));
            dialog.dismiss();
        },5000);
    }
}