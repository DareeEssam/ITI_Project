package com.example.iti_project.core.data_source.remote

import com.example.iti_project.core.model.Comment
import com.example.iti_project.core.model.body.LoginBodyRequest
import com.example.iti_project.core.model.Post
import com.example.iti_project.core.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
     suspend fun getPosts() : Response<ArrayList<Post>>

     @GET("posts")
     suspend fun getPostByUser(@Query("userId") userId: Int) : Response<ArrayList<Post>>

     @GET("posts/{postId}/comments")
     suspend fun getComments(@Path("post_Id") postId : Int) :ArrayList<Comment>

     @POST("auth/login")
     suspend fun login(@Body body : LoginBodyRequest) :Response<UserResponse>
     

     
     
}