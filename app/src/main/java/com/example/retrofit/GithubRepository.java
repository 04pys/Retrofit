package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class GithubRepository {
    long id;

    String name;

    String description;

    @SerializedName("html_url")
    String htmlURL;
}
