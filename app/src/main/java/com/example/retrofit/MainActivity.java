package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView profileImg;
    TextView profileNickText;
    TextView profileIdText;
    RecyclerView recyclerView;
    private UserAndRepositoryAdapter userAndRepositoryAdapter;
    Githubuser user;
    List<GithubRepository> repos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImg = findViewById(R.id.profileImg);
        profileIdText = findViewById(R.id.profileIdText);
        profileNickText = findViewById(R.id.profileNickText);
        userAndRepositoryAdapter = new UserAndRepositoryAdapter();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAndRepositoryAdapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(Githubservice.class);

        Githubservice service = retrofit.create(Githubservice.class);

        Call<Githubuser> userCall = service.getUser("04pys");


        userCall.enqueue(new Callback<Githubuser>() {
            @Override
            public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                Githubuser user = response.body();
                MainActivity.this.user = user;

                if(MainActivity.this.repos != null){
                    List<Object> itemList = new ArrayList<>();
                    itemList.add(user);
                    itemList.addAll(repos);

                    userAndRepositoryAdapter.submitList(itemList);
                }

            }

            @Override
            public void onFailure(Call<Githubuser> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Call<List<GithubRepository>> reposCall = service.getUserRepos("04pys");
        reposCall.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                if(response.isSuccessful()){
                    List<GithubRepository> repos = response.body();
                    MainActivity.this.repos = repos;
                    if(MainActivity.this.user != null){
                        List<Object> itemList = new ArrayList<>();
                        itemList.add(user);
                        itemList.addAll(repos);

                        userAndRepositoryAdapter.submitList(itemList);
                    }
                   // repositoryAdapter.submitList(repos);
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepository>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}