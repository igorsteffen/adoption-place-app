package com.example.adoptionplace.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adoptionplace.R;
import com.example.adoptionplace.model.Dog;
import com.example.adoptionplace.utils.CartManager;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<Dog> cartDogs;
    private Runnable refreshCallback;

    public CartAdapter(Context context, List<Dog> cartDogs, Runnable refreshCallback) {
        this.context = context;
        this.cartDogs = cartDogs;
        this.refreshCallback = refreshCallback;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart_dog, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Dog dog = cartDogs.get(position);

        holder.textViewBreed.setText("Breed: " + dog.getBreed());
        holder.textViewAge.setText("Age: " + dog.getAge() + " years");
        holder.textViewGender.setText("Gender: " + dog.getGender());

        Glide.with(context).load(dog.getImageUrl()).into(holder.dogImage);

        // Remover do carrinho
        holder.btnRemove.setOnClickListener(v -> {
            CartManager.removeFromCart(dog.getImageUrl());
            cartDogs.remove(position);
            notifyItemRemoved(position);
            refreshCallback.run();
        });
    }

    @Override
    public int getItemCount() {
        return cartDogs.size();
    }

    public void updateCart(List<Dog> newCartDogs) {
        this.cartDogs = newCartDogs;
        notifyDataSetChanged();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView dogImage;
        TextView textViewBreed, textViewAge, textViewGender;
        Button btnRemove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            dogImage = itemView.findViewById(R.id.dogImage);
            textViewBreed = itemView.findViewById(R.id.textViewBreed);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewGender = itemView.findViewById(R.id.textViewGender);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}