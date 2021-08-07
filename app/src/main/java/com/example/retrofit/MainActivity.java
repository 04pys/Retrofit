package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView profileImg;
    TextView profileNickText;
    TextView profileIdText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImg = findViewById(R.id.profileImg);
        profileIdText = findViewById(R.id.profileIdText);
        profileNickText = findViewById(R.id.profileNickText);

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
                profileIdText.setText(user.login);
                profileNickText.setText(user.name);

                Glide
                        .with(MainActivity.this)
                        .load(user.avatar_url)
           //             .centerCrop()
                    //    .placeholder(R.drawable.loading_spinner)
                        .into(profileImg);
            }

            @Override
            public void onFailure(Call<Githubuser> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}