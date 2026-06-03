package com.example.foliadeiros.Api;

import com.example.foliadeiros.Model.Foliada;
import com.example.foliadeiros.Model.Provincia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProvinciasApiService {

    @GET("provincias")
    Call<List<Provincia>> getProvincias();

}
