package com.example.adoptionplace.utils;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.adoptionplace.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class CartDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cart.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CART = "cart";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_IMAGE_URL = "image_url";
    private static final String COLUMN_BREED = "breed";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_GENDER = "gender";

    public CartDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_CART + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_IMAGE_URL + " TEXT, " +
                COLUMN_BREED + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_GENDER + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        onCreate(db);
    }

    public void addDogToCart(Dog dog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE_URL, dog.getImageUrl());
        values.put(COLUMN_BREED, dog.getBreed());
        values.put(COLUMN_AGE, dog.getAge());
        values.put(COLUMN_GENDER, dog.getGender());

        db.insert(TABLE_CART, null, values);
        db.close();
    }

    public List<Dog> getCartDogs() {
        List<Dog> cartDogs = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CART, new String[]{COLUMN_IMAGE_URL, COLUMN_BREED, COLUMN_AGE, COLUMN_GENDER},
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Dog dog = new Dog(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3)
                );
                cartDogs.add(dog);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return cartDogs;
    }

    public void removeDogFromCart(String imageUrl) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, COLUMN_IMAGE_URL + " = ?", new String[]{imageUrl});
        db.close();
    }

    public void clearCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, null, null);
        db.close();
    }
}