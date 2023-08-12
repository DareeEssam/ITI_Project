package com.example.iti_project

import com.example.iti_project.model.Post

interface MyCustomClickListener {
    fun onItemClick(post: Post, position: Int)
}