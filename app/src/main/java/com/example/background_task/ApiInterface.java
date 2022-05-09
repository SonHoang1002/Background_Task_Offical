package com.example.background_task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<ArrayList<User>> getAllUsers();
    @GET("users/{id}?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<User> getUserById(@Path("id") int id);
    @PUT("users/{id}?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<String> updateUserById(@Path("id") int id, @Body() User user);
    @DELETE("users/{id}?access-token=88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba")
    Call<User> deleteUserById(@Path("id") int id);
}






