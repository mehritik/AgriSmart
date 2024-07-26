package org.hritik.aipoweredagriculture;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {
    AppCompatButton foreBtn,detectBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foreBtn = findViewById(R.id.forecastingBtn);
        detectBtn = findViewById(R.id.detectionBtn);

        foreBtn.setOnClickListener(v->startActivity(new Intent(this,MapActivity.class)));
        detectBtn.setOnClickListener(v-> ImagePicker.with(MainActivity.this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start(11));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11 && data !=null){
            Uri localUri = data.getData();
            if(localUri != null){
                openResultAct(localUri);
            }
        }
    }

    private void openResultAct(Uri uri) {
        Intent resIntent = new Intent(MainActivity.this, DetectionActivity.class);
        resIntent.putExtra("ImgUri",String.valueOf(uri));
        startActivity(resIntent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }



}