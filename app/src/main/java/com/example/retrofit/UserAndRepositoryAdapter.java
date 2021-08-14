package com.example.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class UserAndRepositoryAdapter extends ListAdapter<Object, RecyclerView.ViewHolder> {
    public UserAndRepositoryAdapter() {
        super(new UserAndRepositoryDiffUtil());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 1: {
                View view = inflater.inflate(R.layout.item_user, parent, false);
                return new UserViewHolder(view);
            }
            case 2:{
                View view = inflater.inflate(R.layout.item_repository,parent,false);
                return new RepositoryViewHolder(view);
            }
        }
            View view = inflater.inflate(R.layout.item_repository,parent,false);
            return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof UserViewHolder){
            Githubuser githubuser = (Githubuser) getCurrentList().get(position);
            ((UserViewHolder) holder).bind(githubuser);
        }
        if(holder instanceof RepositoryViewHolder){
            GithubRepository githubRepository = (GithubRepository) getCurrentList().get(position);
            ((RepositoryViewHolder) holder).bind(githubRepository);
        }
    }

    @Override
    public int getItemViewType(int position){
        Object item = getCurrentList().get(position);
        if(item instanceof Githubuser){
            return 1;
        }
        if(item instanceof GithubRepository){
            return 2;
        }
        return -1;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nickName;
        TextView profileId;
        ImageView profileImg;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            profileId = itemView.findViewById(R.id.profileIdText);
            nickName = itemView.findViewById(R.id.profileNickText);
            profileImg = itemView.findViewById(R.id.profileImg);
        }

        public void bind(Githubuser user) {
            profileId.setText(user.login);
            nickName.setText(user.name);

            Glide
                    .with(itemView)
                    .load(user.avatar_url)
//                        .centerCrop()
//                        .placeholder(R.drawable.loading_spinner)
                    .into(profileImg);
        }

    }
    class RepositoryViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;

        public RepositoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.repoNameText);
            description = itemView.findViewById(R.id.repoDescriptionText);
        }

        public void bind(GithubRepository repository) {
            name.setText(repository.name);
            description.setText(repository.description);
        }

    }
}
