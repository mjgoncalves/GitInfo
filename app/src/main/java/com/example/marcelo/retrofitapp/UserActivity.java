package com.example.marcelo.retrofitapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import model.GitHubUser;
import rest.APIClient;
import rest.GitHubUserEndPoints;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";

    private TextView username, login, email;
    private TextView following, followers;
    private Button btnShowRepos;
    private Intent incomingIntent;
    private Bundle extras;
    private String extraString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initWidgets();
        getIncomingIntent();
        loadData();

    }

    private void loadData() {

        final GitHubUserEndPoints apiService = APIClient.getClient().create(GitHubUserEndPoints.class);
        Call<GitHubUser> call = apiService.getUser(extraString);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(@NonNull Call<GitHubUser> call, @NonNull Response<GitHubUser> response) {

                assert response.body() != null;
                if (response.body().getName() == null){

                    username.setText(getString(R.string.field_email) + " " + getString(R.string.no_name));
                }else {

                    username.setText(getString(R.string.field_username) + " " + response.body().getName());

                }

                if (response.body().getEmail() == null){

                    email.setText(getString(R.string.field_email) + " " + getString(R.string.no_mail));

                }else {

                    email.setText(getString(R.string.field_email) + " " + response.body().getEmail());

                }

                login.setText(getString(R.string.field_login) + " " + response.body().getLogin());
                followers.setText(getString(R.string.field_followers) + " " + response.body().getFollowers());
                following.setText(getString(R.string.field_following) + " " + response.body().getFollowing());

            }

            @Override
            public void onFailure(@NonNull Call<GitHubUser> call, @NonNull Throwable t) {

            }
        });
    }


    private void getIncomingIntent(){

        incomingIntent = getIntent();
        if (incomingIntent.hasExtra("USERNAME")){

            extraString = incomingIntent.getStringExtra("USERNAME");

        }
    }

    private void initWidgets(){

        username = findViewById(R.id.username);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        followers = findViewById(R.id.followers);
        following = findViewById(R.id.following);
        btnShowRepos = findViewById(R.id.btn_show_repos);
    }
}
