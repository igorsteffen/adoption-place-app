package com.example.adoptionplace.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adoptionplace.DogDetailActivity;
import com.example.adoptionplace.R;
import com.example.adoptionplace.model.Dog;
import com.example.adoptionplace.utils.CartManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    private Context context;
    private List<String> dogImages = new ArrayList<>();
    private Random random = new Random();
    public DogAdapter(Context context, List<String> dogList) {
        this.context = context;
        this.dogImages = dogImages;
    }

    public void setDogImages(List<String> dogImages) {
        if (dogImages != null) {
            this.dogImages = dogImages;
            notifyDataSetChanged(); // Atualiza a UI após modificar a lista
        }
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        String imageUrl = dogImages.get(position);

        // 🐶 Extrair raça do nome da imagem
        String breed = extractBreedFromUrl(imageUrl);

        // 🔢 Gerar idade aleatória entre 0 e 15 anos
        int age = random.nextInt(16);

        // ♀️♂️ Definir gênero aleatório
        String gender = random.nextBoolean() ? "Male" : "Female";

        // Criar o objeto `Dog`
        Dog dog = new Dog(imageUrl, breed, age, gender);

        // Carregar a imagem do cachorro com Glide
        Glide.with(context)
                .load(imageUrl)
                .into(holder.imageViewDog);

        // Configurar os dados no card
        holder.textViewBreed.setText("Breed: " + breed);
        holder.textViewAge.setText("Age: " + age + " years");
        holder.textViewGender.setText("Gender: " + gender);

        // 🛒 Configurar ação do botão "Adopt"
        holder.btnAdopt.setOnClickListener(v -> {
            CartManager.addDogToCart(dog);
            Toast.makeText(context, breed + " added to cart!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return dogImages.size();
    }

    public static class DogViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewDog;
        TextView textViewBreed, textViewAge, textViewGender;
        Button btnAdopt;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDog = itemView.findViewById(R.id.imageViewDog);
            textViewBreed = itemView.findViewById(R.id.textViewBreed);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewGender = itemView.findViewById(R.id.textViewGender);
            btnAdopt = itemView.findViewById(R.id.btnAdopt);
        }
    }
    // Método para extrair a raça da URL da imagem
    private String extractBreedFromUrl(String imageUrl) {
        String[] parts = imageUrl.split("/");
        int breedIndex = 4; // Índice onde geralmente está a raça (pode variar)
        if (parts.length > breedIndex) {
            return parts[breedIndex].replace("-", " ").toUpperCase();
        }
        return "Unknown Breed";
    }
}
