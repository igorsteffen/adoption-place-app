package com.example.adoptionplace.utils;
import android.content.Context;

import com.example.adoptionplace.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartDatabaseHelper dbHelper;
    private static final List<Dog> cartDogs = new ArrayList<>();

    public static void initialize(Context context) {
        dbHelper = new CartDatabaseHelper(context);
    }

    public static void addDogToCart(Dog dog) {
        dbHelper.addDogToCart(dog);
    }

    public static List<Dog> getCartDogs() {
        return dbHelper.getCartDogs();
    }

    public static void removeFromCart(String imageUrl) {
        dbHelper.removeDogFromCart(imageUrl);
    }

    public static void clearCart() {
        dbHelper.clearCart();
    }
}