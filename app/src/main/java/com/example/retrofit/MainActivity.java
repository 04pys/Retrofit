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
    Githubuser userPYS;
    Githubuser userJMJ;
    Githubuser userOIS;
    Githubuser userLJS;
    List<GithubRepository> reposPYS;
    List<GithubRepository> reposJMJ;
    List<GithubRepository> reposOIS;
    List<GithubRepository> reposLJS;
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

        Call<Githubuser> userCallPYS = service.getUser("04pys");



        //PYS
        userCallPYS.enqueue(new Callback<Githubuser>() {
            @Override
            public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                Githubuser user = response.body();
                MainActivity.this.userPYS = user;

                if(MainActivity.this.reposPYS != null){
                    List<Object> itemList = new ArrayList<>();
                    itemList.add(user);
                    itemList.addAll(reposPYS);

                    userAndRepositoryAdapter.submitList(itemList);
                }

            }

            @Override
            public void onFailure(Call<Githubuser> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Call<List<GithubRepository>> reposCallPYS = service.getUserRepos("04pys");
        reposCallPYS.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                if(response.isSuccessful()){
                    List<GithubRepository> repos = response.body();
                    MainActivity.this.reposPYS = repos;
                    if(MainActivity.this.userPYS != null){
                        List<Object> itemList = new ArrayList<>();
                        itemList.add(userPYS);
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

        //JMJ
        Call<Githubuser> userCallJMJ = service.getUser("polaris428");
        userCallJMJ.enqueue(new Callback<Githubuser>() {
            @Override
            public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                Githubuser user = response.body();
                MainActivity.this.userJMJ = user;

                if(MainActivity.this.reposJMJ != null){
                    List<Object> itemList = new ArrayList<>();
                    itemList.add(user);
                    itemList.addAll(reposJMJ);

                    userAndRepositoryAdapter.submitList(itemList);
                }

            }

            @Override
            public void onFailure(Call<Githubuser> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Call<List<GithubRepository>> reposCallJMJ = service.getUserRepos("polaris428");
        reposCallJMJ.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                if(response.isSuccessful()){
                    List<GithubRepository> repos = response.body();
                    MainActivity.this.reposJMJ = repos;
                    if(MainActivity.this.userJMJ != null){
                        List<Object> itemList = new ArrayList<>();
                        itemList.add(userJMJ);
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

        //OIS
        Call<Githubuser> userCallOIS = service.getUser("inseong04");
        userCallOIS.enqueue(new Callback<Githubuser>() {
            @Override
            public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                Githubuser user = response.body();
                MainActivity.this.userOIS = user;

                if(MainActivity.this.reposOIS != null){
                    List<Object> itemList = new ArrayList<>();
                    itemList.add(user);
                    itemList.addAll(reposOIS);

                    userAndRepositoryAdapter.submitList(itemList);
                }

            }

            @Override
            public void onFailure(Call<Githubuser> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Call<List<GithubRepository>> reposCallOIS = service.getUserRepos("polaris428");
        reposCallOIS.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                if(response.isSuccessful()){
                    List<GithubRepository> repos = response.body();
                    MainActivity.this.reposOIS = repos;
                    if(MainActivity.this.userOIS != null){
                        List<Object> itemList = new ArrayList<>();
                        itemList.add(userOIS);
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
        //LJS
        Call<Githubuser> userCallLJS = service.getUser("samgashyeong");
        userCallLJS.enqueue(new Callback<Githubuser>() {
            @Override
            public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                Githubuser user = response.body();
                MainActivity.this.userLJS = user;

                if(MainActivity.this.reposLJS != null){
                    List<Object> itemList = new ArrayList<>();
                    itemList.add(user);
                    itemList.addAll(reposLJS);

                    userAndRepositoryAdapter.submitList(itemList);
                }

            }

            @Override
            public void onFailure(Call<Githubuser> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Call<List<GithubRepository>> reposCallLJS = service.getUserRepos("polaris428");
        reposCallLJS.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                if(response.isSuccessful()){
                    List<GithubRepository> repos = response.body();
                    MainActivity.this.reposLJS = repos;
                    if(MainActivity.this.userLJS != null){
                        List<Object> itemList = new ArrayList<>();
                        itemList.add(userLJS);
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