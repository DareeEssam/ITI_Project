package com.example.iti_project.model

import com.google.gson.annotations.SerializedName

data class LoginBodyRequest (


    @SerializedName("username")
    val username : String,

    @SerializedName("password")
    val password : String

        ){}
