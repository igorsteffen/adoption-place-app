package com.example.adoptionplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.bumptech.glide.Glide;
import com.example.adoptionplace.utils.CartManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🚀 Inicializa o CartManager
        CartManager.initialize(this);

        ImageView gifImageView2 = findViewById(R.id.gifImageView2);

        // Carrega um GIF da pasta res/drawable
        Glide.with(this)
                .asGif()
                .load(R.drawable.gif_dog)  // Nome do GIF na pasta drawable
                .into(gifImageView2);

    }

    public void goToAdoption(View view) {
        // Criar animação de clique
        ScaleAnimation scale = new ScaleAnimation(
                1f, 0.95f, // De 100% para 95% no eixo X
                1f, 0.95f, // De 100% para 95% no eixo Y
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(100); // Duração rápida
        scale.setFillAfter(true);

        // Aplicar animação ao botão
        view.startAnimation(scale);

        // Chamar a Activity de adoção após a animação
        view.postDelayed(() -> {
            view.clearAnimation(); // Voltar ao tamanho normal
            startActivity(new Intent(this, AdoptionListActivity.class));
        }, 150);
    }

    public boolean goToHome(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }

    public boolean goToDogs(MenuItem item) {
        Intent intent = new Intent(this, AdoptionListActivity.class);
        startActivity(intent);
        return true;
    }

    public boolean goToCart(MenuItem item) {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
        return true;
    }

    public boolean goToLogin(MenuItem item) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        return true;
    }


}