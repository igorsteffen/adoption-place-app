package com.example.adoptionplace;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adoptionplace.adapter.DogAdapter;
import com.example.adoptionplace.model.DogResponse;
import com.example.adoptionplace.network.DogApiService;
import com.example.adoptionplace.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdoptionListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DogAdapter dogAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_list);

        recyclerView = findViewById(R.id.recyclerViewDogs);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializa o adapter com uma lista vazia
        dogAdapter = new DogAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(dogAdapter);

        // Carregar os dados da API
        loadDogs();
    }

    private void loadDogs() {
        progressBar.setVisibility(View.VISIBLE); // Mostra o carregamento

        DogApiService apiService = RetrofitClient.getRetrofitInstance().create(DogApiService.class);
        Call<DogResponse> call = apiService.getRandomDogs();

        call.enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(@NonNull Call<DogResponse> call, @NonNull Response<DogResponse> response) {
                progressBar.setVisibility(View.GONE); // Esconde o carregamento

                if (response.isSuccessful() && response.body() != null && response.body().getMessage() != null) {
                    List<String> dogImages = response.body().getMessage();

                    if (!dogImages.isEmpty()) {
                        dogAdapter.setDogImages(dogImages);
                    } else {
                        Toast.makeText(AdoptionListActivity.this, "Nenhum cachorro encontrado. Tente novamente mais tarde!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AdoptionListActivity.this, "Erro ao buscar cachorros", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DogResponse> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e("API Error", "Erro ao buscar cachorros", t);
                Toast.makeText(AdoptionListActivity.this, "Erro de conexão", Toast.LENGTH_SHORT).show();
            }
        });
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