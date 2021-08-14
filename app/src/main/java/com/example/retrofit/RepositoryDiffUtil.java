package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class RepositoryDiffUtil extends DiffUtil.ItemCallback<GithubRepository> {

    @Override
    public boolean areItemsTheSame(@NonNull GithubRepository oldItem, @NonNull GithubRepository newItem) {
        return oldItem.id == newItem.id;
    }

    @Override
    public boolean areContentsTheSame(@NonNull GithubRepository oldItem, @NonNull GithubRepository newItem) {
        return (oldItem.name.equals(newItem.name) &&
                oldItem.description.equals(newItem.description) &&
                oldItem.htmlURL.equals(newItem.htmlURL)
        );
    }
}