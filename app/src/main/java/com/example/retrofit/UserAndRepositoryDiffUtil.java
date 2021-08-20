package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class UserAndRepositoryDiffUtil extends DiffUtil.ItemCallback<Object> {
    @Override
    public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        if (oldItem instanceof Githubuser) {
            if (newItem instanceof GithubRepository) {
                return false;
            }

            Githubuser oldUser = (Githubuser) oldItem;
            Githubuser newUser = (Githubuser) newItem;

            return oldUser.login.equals(newUser.login);
        }
        if (oldItem instanceof GithubRepository) {
            if (newItem instanceof Githubuser) {
                return false;
            }

            GithubRepository oldRepo = (GithubRepository) oldItem;
            GithubRepository newRepo = (GithubRepository) newItem;

            return oldRepo.id == newRepo.id;
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        if (oldItem instanceof Githubuser) {
            if (newItem instanceof GithubRepository) {
                return false;
            }

            Githubuser oldUser = (Githubuser) oldItem;
            Githubuser newUser = (Githubuser) newItem;

            return oldUser.avatar_url.equals(newUser.avatar_url)
                    && oldUser.login.equals(newUser.login)
                    && oldUser.name.equals(newUser.name);
        }
        if (oldItem instanceof GithubRepository) {
            if (newItem instanceof Githubuser) {
                return false;
            }

            GithubRepository oldRepo = (GithubRepository) oldItem;
            GithubRepository newRepo = (GithubRepository) newItem;

            //이 부분에서 오류가 발생하는것 같은데 해결하지 못하였습니다,,
            return oldRepo.htmlURL.equals(newRepo.htmlURL)
                    && oldRepo.description.equals(newRepo.description)
                    && oldRepo.name.equals(newRepo.name);
        }
        return false;
    }
}
