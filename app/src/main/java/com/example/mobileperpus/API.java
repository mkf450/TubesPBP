package com.example.mobileperpus;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

//    @GET("/showAnggota")
//    Call<List<Anggota>> getAnggota();

    @GET("/api/allAnggota")
    Call<List<Anggota>> getAnggota();

    @POST("/api/tambahAnggota")
    Call<Anggota> createAnggota(@Body Anggota anggota);

}