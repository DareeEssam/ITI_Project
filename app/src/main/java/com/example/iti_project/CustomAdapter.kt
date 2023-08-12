package com.example.iti_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.databinding.PostItemActivityBinding
import com.example.iti_project.model.Post


class CustomAdapter(private val postsList: List<Post>, var listener: MyCustomClickListener) {

    inner class ViewHolder(val binding: PostItemActivityBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            PostItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun getItemCount(): Int {
        return postsList.size
    }

    fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPost = postsList[position]
        val context = holder.binding.root.context

        holder.binding.usernameTextview.text = postsList[position].userId.toString()
        holder.binding.dateTextview.text = postsList[position].id.toString()
        holder.binding.postTextView.text = postsList[position].title
        holder.binding.bodyTextView.text= postsList[position].body


        holder.binding.detailsButton.setOnClickListener {
           listener.onItemClick(postsList[position],position)
        }


    }

}