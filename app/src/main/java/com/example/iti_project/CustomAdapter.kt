package com.example.iti_project

import ThirdActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iti_project.databinding.PostItemActivityBinding
import com.squareup.picasso.Picasso


class CustomAdapter(private val postsList: List<Posts>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PostItemActivityBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            PostItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPost = postsList[position]
        val context = holder.binding.root.context

        holder.binding.usernameTextview.text = currentPost.UserName
        holder.binding.dateTextview.text = currentPost.PostDate
        holder.binding.postTextView.text = currentPost.PostText

        Picasso.get().load(currentPost.ImageUrl).into(holder.binding.imageView)


        holder.binding.detailsButton.setOnClickListener {
            val intent = Intent(context, ThirdActivity::class.java)
            intent.putExtra("username", currentPost.UserName)
            intent.putExtra("postText", currentPost.PostText)
            context.startActivity(intent)
        }


    }

}