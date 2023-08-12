package com.example.iti_project.utils

import android.security.identity.AccessControlProfileId
import com.example.iti_project.model.Comment
import com.example.iti_project.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts")
     suspend fun getPosts() : Response<ArrayList<Post>>

     @GET("posts")
     suspend fun getPostByUser(@Query("userId") userId: Int) : Response<ArrayList<Post>>

     @GET("posts/{postId}/comments")
     suspend fun getComments(@Path("post_Id") postId : Int) :ArrayList<Comment>
}