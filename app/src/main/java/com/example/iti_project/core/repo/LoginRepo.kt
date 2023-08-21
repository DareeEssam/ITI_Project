package com.example.iti_project.core.repo

import com.example.iti_project.core.data_source.remote.ApiInterface
import com.example.iti_project.core.data_source.remote.RetrofitClient
import com.example.iti_project.core.model.body.LoginBodyRequest
import com.example.iti_project.core.model.response.UserResponse
import retrofit2.Response
import retrofit2.Retrofit

class LoginRepo {

    val retrofit = RetrofitClient.getInstance("https://dummyjson.com/")

   suspend fun login(username :String, password :String) : Response<UserResponse>{

       return retrofit.login(LoginBodyRequest(username,password))

    }

}