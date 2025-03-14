package com.example.adoptionplace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DogDetailActivity extends AppCompatActivity {
    private ImageView dogImageView;
    private Button adoptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_detail);

        dogImageView = findViewById(R.id.dogImageView);
        adoptButton = findViewById(R.id.adoptButton);

        // Recebendo a URL da imagem do cachorro
        Intent intent = getIntent();
        String dogImageUrl = intent.getStringExtra("dogImageUrl");

        // Exibindo a imagem
        Glide.with(this).load(dogImageUrl).into(dogImageView);

        // Configurando botão de adoção (pode ser aprimorado no futuro)
        adoptButton.setOnClickListener(v -> {
            // Aqui você pode adicionar lógica para adoção
        });
    }
}