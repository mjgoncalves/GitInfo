package com.example.marcelo.retrofitapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import model.GitHubRepo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ReposViewHolder>{

    private List<GitHubRepo> repos;
    private int rowLayout;
    private Context context;

    public RecyclerViewAdapter(List<GitHubRepo> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

//    public List<GitHubRepo> getRepos() {return repos;}
//
//    public void setRepos(List<GitHubRepo> repos) {this.repos = repos;}
//
//    public int getRowLayout() {return rowLayout;}
//
//    public void setRowLayout(int rowLayout) {this.rowLayout = rowLayout;}

    public Context getContext() {return context;}

    public void setContext(Context context) {this.context = context;}

    public static class ReposViewHolder extends RecyclerView.ViewHolder{

        LinearLayout repoLayout;
        TextView repoName;
        TextView repoDescription;
        TextView repoLanguage;

        public ReposViewHolder(@NonNull View itemView) {

            super(itemView);
            repoLayout = itemView.findViewById(R.id.repos_item_layout);
            repoName = itemView.findViewById(R.id.repo_name);
            repoDescription = itemView.findViewById(R.id.repo_description);
            repoLanguage = itemView.findViewById(R.id.repo_language);
        }
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder reposViewHolder, int position) {

        reposViewHolder.repoName.setText(repos.get(position).getName());
        reposViewHolder.repoDescription.setText(repos.get(position).getDescription());
        reposViewHolder.repoLanguage.setText(repos.get(position).getLanguage());

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }


}
