package com.example.swipe_delete;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("menu.json")
    Call<List<GetterSetter>> getMenu();

}
