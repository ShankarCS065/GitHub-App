package com.example.githubapp.api

import com.example.githubapp.data.model.DetailUserResponse
import com.example.githubapp.data.model.Repo
import com.example.githubapp.data.model.User
import com.example.githubapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    fun getUserDetail(
        @Path("username") username:String
    ):Call<DetailUserResponse>

    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username") username: String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String
    ):Call<ArrayList<User>>

    @GET("users/{username}/repos")
    fun getRepos(
        @Path("username") username: String
    ):Call<ArrayList<Repo>>

}