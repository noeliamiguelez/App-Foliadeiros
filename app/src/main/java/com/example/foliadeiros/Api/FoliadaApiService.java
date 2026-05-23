package com.example.foliadeiros.Api;

import com.example.foliadeiros.Model.Foliada;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FoliadaApiService {

    @GET("foliadas")
    Call<List<Foliada>> getAll();

    @GET("foliadas/{id}")
    Call<Foliada> getById(@Path("id") int id);

    @GET("foliadas/provincia/{id}")
    Call<List<Foliada>> getByProvincia(@Path("id") int provinciaId);

    @POST("foliadas")
    Call<Foliada> create(@Body Foliada foliada);

    @PUT("foliadas/{id}")
    Call<Foliada> update(@Path("id") int id, @Body Foliada foliada);

    @GET("foliadas/buscar/{nome}")
    Call<List<Foliada>> buscarFoliadas(@Path("nome") String nome);

}
