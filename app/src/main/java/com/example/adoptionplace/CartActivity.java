package com.example.adoptionplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adoptionplace.adapter.CartAdapter;
import com.example.adoptionplace.model.Dog;
import com.example.adoptionplace.utils.CartManager;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        CartManager.initialize(this);

        recyclerView = findViewById(R.id.recyclerViewCart);
        btnCheckout = findViewById(R.id.btnCheckout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obter os cães do carrinho
        List<Dog> cartDogs = CartManager.getCartDogs();

        cartAdapter = new CartAdapter(this, cartDogs, this::refreshCart);
        recyclerView.setAdapter(cartAdapter);

        // Botão de Checkout (ainda sem funcionalidade)
        btnCheckout.setOnClickListener(v -> {
            Toast.makeText(CartActivity.this, "Feature not implemented yet!", Toast.LENGTH_SHORT).show();
        });
    }
    private void refreshCart() {
        List<Dog> updatedCartDogs = CartManager.getCartDogs();
        cartAdapter.updateCart(updatedCartDogs);
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

