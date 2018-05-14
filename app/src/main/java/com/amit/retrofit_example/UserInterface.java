package com.amit.retrofit_example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dell on 5/14/2018.
 */

public interface UserInterface {

    public  String URL = "https://api.github.com/";

    @GET("users")
    Call<List<User>> getUsers();
}
