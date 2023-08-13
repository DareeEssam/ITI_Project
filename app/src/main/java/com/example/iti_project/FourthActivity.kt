package com.example.iti_project


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.iti_project.databinding.ActivityFourthBinding
import com.example.iti_project.model.Comment
import com.example.iti_project.utils.ApiInterface
import com.example.iti_project.utils.RetrofitClient
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

class FourthActivity : AppCompatActivity() {

    lateinit var binding: ActivityFourthBinding
    lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val postId = intent.extras?.getInt("post_id", 0)
        val commentId = intent.extras?.getInt("comment_id", 0)
        val name = intent.extras?.getString("name", "")
        val email = intent.extras?.getString("email", "")
        val comment = intent.extras?.getString("body", "")

        binding.postIdTv.text = "post id: $postId"
        binding.commentIdTv.text = "comment id: $commentId"
        binding.nameIdTv.text = "name: $name"
        binding.emailIdTv.text = "email: $email"
        binding.commentTv.text = "comment: $comment"
    }
}