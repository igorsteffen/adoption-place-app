package com.example.adoptionplace.network;

import com.example.adoptionplace.model.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogApiService {
    @GET("breeds/image/random/10") // Retorna 10 imagens aleatórias de cachorros
    Call<DogResponse> getRandomDogs();
}
