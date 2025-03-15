package com.example.adoptionplace.utils;
import android.content.Context;

import com.example.adoptionplace.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartDatabaseHelper dbHelper;
    private static final List<Dog> cartDogs = new ArrayList<>();

    public static void initialize(Context context) {
        if (dbHelper == null) {
            dbHelper = new CartDatabaseHelper(context);
        }
    }

    public static void addDogToCart(Dog dog) {
        if (dbHelper == null) {
            throw new IllegalStateException("CartManager not initialized. Call CartManager.initialize(context) first.");
        }
        dbHelper.addDogToCart(dog);

    }

    public static List<Dog> getCartDogs() {
        if (dbHelper == null) {
            throw new IllegalStateException("CartManager not initialized. Call CartManager.initialize(context) first.");
        }
        return dbHelper.getCartDogs();
    }

    public static void removeFromCart(String imageUrl) {
        if (dbHelper == null) {
            throw new IllegalStateException("CartManager not initialized. Call CartManager.initialize(context) first.");
        }
        dbHelper.removeDogFromCart(imageUrl);
    }

    public static void clearCart() {
        if (dbHelper == null) {
            throw new IllegalStateException("CartManager not initialized. Call CartManager.initialize(context) first.");
        }
        dbHelper.clearCart();
    }
}