package com.example.adoptionplace.model;
import java.io.Serializable;

public class Dog implements Serializable {
    private String imageUrl;
    private String breed;
    private int age;
    private String gender;

    public Dog(String imageUrl, String breed, int age, String gender) {
        this.imageUrl = imageUrl;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}