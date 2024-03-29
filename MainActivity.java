package com.example.gamemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView kalan,skor;
    ImageView [] images;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kalan=findViewById(R.id.kalan);
        skor=findViewById(R.id.skor);
        images= new ImageView[] {findViewById(R.id.imageView),findViewById(R.id.imageView2),findViewById(R.id.imageView3),findViewById(R.id.imageView4),findViewById(R.id.imageView5),findViewById(R.id.imageView6),findViewById(R.id.imageView7),findViewById(R.id.imageView8),findViewById(R.id.imageView9),findViewById(R.id.imageView10),findViewById(R.id.imageView11)};
        hideImages();
        new CountDownTimer(10000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                hideImages();
                Random random=new Random();
                int rastgele=random.nextInt(11);
                kalan.setText("Kalan: "+millisUntilFinished/1000+" saniye");
                images[rastgele].setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                hideImages();

            }
        }.start();
    }
    public void hideImages(){
        for(ImageView gezici:images){
            gezici.setVisibility(View.INVISIBLE);
        }
    }

    public void click(View view) {
        score++;
        skor.setText("Skor: "+score);
    }
}