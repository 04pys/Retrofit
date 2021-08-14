package com.example.retrofit;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Githubservice {

    @GET("/users/{user}")
    Call<Githubuser> getUser(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<GithubRepository>> getUserRepos(@Path("user") String user);


}
