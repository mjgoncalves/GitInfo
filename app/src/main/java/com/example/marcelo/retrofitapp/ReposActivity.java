package com.example.marcelo.retrofitapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import model.GitHubRepo;
import rest.APIClient;
import rest.GithubRepoEndPoints;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposActivity extends AppCompatActivity {

    private String incommingString;
    private TextView username;
    private RecyclerView recyclerView;
    private List<GitHubRepo> myDataSource = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        username = findViewById(R.id.username);
        Bundle  extras = getIntent().getExtras();
        assert extras != null;
        incommingString = extras.getString("USERNAME");
        username = findViewById(R.id.username);
        username.setText(incommingString);
        recyclerView = findViewById(R.id.rec_repos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(myDataSource, R.layout.list_item_repos, getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        loadRepositories();
    }

    private void loadRepositories() {

        GithubRepoEndPoints apiService = APIClient.getClient().create(GithubRepoEndPoints.class);
        Call<List<GitHubRepo>> call = apiService.getRepo(incommingString);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(@NonNull Call<List<GitHubRepo>> call, @NonNull Response<List<GitHubRepo>> response) {

                myDataSource.clear();
                assert response.body() != null;
                myDataSource.addAll(response.body());
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<GitHubRepo>> call, @NonNull Throwable t) {

            }
        });
    }


}
