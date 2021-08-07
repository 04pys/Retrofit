package com.example.retrofit;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Githubservice {

    @GET("/users/{user}")
    Call<Githubuser> getUser(@Path("user") String user);



}
