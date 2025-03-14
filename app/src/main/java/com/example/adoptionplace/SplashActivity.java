package com.example.adoptionplace;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        ImageView gifImageView = findViewById(R.id.gifImageView);

        // Carrega um GIF da pasta res/drawable
        Glide.with(this)
                .asGif()
                .load(R.drawable.gid_dog2)  // Nome do GIF na pasta drawable
                .into(gifImageView);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }, 10000);
    }
}
