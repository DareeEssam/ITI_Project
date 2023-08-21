package com.example.iti_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.databinding.PostItemActivityBinding
import com.example.iti_project.core.model.Post

class CustomAdapter(private val postsList: List<Post>, private val listener: MyCustomClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPost = postsList[position]

        holder.binding.usernameTextview.text = currentPost.userId.toString()
        holder.binding.dateTextview.text = currentPost.id.toString()
        holder.binding.postTextView.text = currentPost.title
        holder.binding.bodyTextView.text = currentPost.body

        holder.binding.detailsButton.setOnClickListener {
            listener.onItemClick(currentPost, position)
        }
    }

    inner class ViewHolder(val binding: PostItemActivityBinding) : RecyclerView.ViewHolder(binding.root)
}
