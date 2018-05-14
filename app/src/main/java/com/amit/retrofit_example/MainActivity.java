package com.amit.retrofit_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LayoutInflater layoutInflater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UserInterface.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        UserInterface userInterface = retrofit.create(UserInterface.class);

        Call<List<User>> call = userInterface.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.e("Main", response.toString());

                List<User> users = response.body();
                User[] users1 = users.toArray(new User[0]);

                recyclerView.setAdapter(new GithubAdapter(MainActivity.this, users1));

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Main", t.toString());
            }
        });
    }
}
