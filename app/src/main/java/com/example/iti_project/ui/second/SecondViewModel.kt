package com.example.iti_project.ui.second

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iti_project.core.data_source.remote.ApiInterface
import com.example.iti_project.core.data_source.remote.RetrofitClient
import com.example.iti_project.core.model.Post

class SecondViewModel(private val sharedPref: SharedPreferences) : ViewModel() {

    val retrofit: ApiInterface = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = _posts

    fun loadPosts() {
        // Fetch posts from the remote data source using retrofit
        // Update the _posts LiveData with the fetched data
    }

    fun logout() {
        val editor = sharedPref.edit()
        editor.putBoolean("LOGIN", false)
        editor.apply()
    }
}
