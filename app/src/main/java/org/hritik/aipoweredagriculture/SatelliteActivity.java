package org.hritik.aipoweredagriculture;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Locale;
import java.util.Random;

public class SatelliteActivity extends AppCompatActivity {
    TextToSpeech tts;
    AppCompatButton downloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satellite);
        int[] images = {R.drawable.img2,R.drawable.img3,R.drawable.img5,R.drawable.img6,
                R.drawable.img4,};
        changeImg(images);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.US);
                }
            }
        });

        downloadBtn = findViewById(R.id.downloadBtn);
        downloadBtn.setOnClickListener(v->{
            Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show();
        });

        ImageView volumeBtn = findViewById(R.id.volumeBtn);
        volumeBtn.setOnClickListener(v->{
            tts.speak("Available for rice cultivation",TextToSpeech.QUEUE_FLUSH,null);
        });


    }

    private void changeImg(int[] images){
        ImageView imageView = findViewById(R.id.satImg);
        new Handler().postDelayed(() -> {
            imageView.setImageResource(images[new Random().nextInt(4)]);
            changeImg(images);
        },1100);
    }

    public void goBack2(View view) {
        onBackPressed();
    }
}