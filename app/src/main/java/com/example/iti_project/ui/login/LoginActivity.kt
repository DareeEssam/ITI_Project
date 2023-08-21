package com.example.iti_project.ui.login


import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.iti_project.R
import com.example.iti_project.ui.second.SecondActivity
import com.example.iti_project.databinding.ActivityMainBinding
import com.example.iti_project.core.model.body.LoginBodyRequest
import com.example.iti_project.core.data_source.remote.ApiInterface
import com.example.iti_project.core.data_source.remote.RetrofitClient

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var SharedPref: SharedPreferences
    lateinit var retrofit : ApiInterface
    lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = LoginViewModel()


        retrofit = RetrofitClient.getInstance("https://dummyjson.com/")


        SharedPref= applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)

        viewModel.loginData.observe(this){
            Toast.makeText(this,"Welcome ${it.body()?.firstName}" , Toast.LENGTH_LONG).show()
        }



        binding.loginBt.setOnClickListener {

           /* lifecycleScope.launchWhenCreated {

                val body = LoginBodyRequest(binding.usernameEt.text.toString(),binding.passwordEt.text.toString())

                val response = retrofit.login(body)

                if(response.isSuccessful){
                    moveToNextScreen()
                }else{
                    Toast.makeText(this@LoginActivity,"Error",Toast.LENGTH_LONG).show()
                }



            }*/
            viewModel.startLogin(binding.usernameEt.text.toString(),binding.passwordEt.text.toString())




        }
    }

    fun moveToNextScreen(){
        val editor = SharedPref.edit()
        editor.putString("USERNAME ${binding.usernameEt.text.toString()}" ,binding.usernameEt.text.toString())
        editor.putString("PASSWORD ${binding.usernameEt.text.toString()}",binding.passwordEt.text.toString())
        editor.putBoolean("LOGIN",true)
        editor.commit()


        val username = binding.usernameEt.text.toString()

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("USERNAME_KEY", username)
        startActivity(intent)
        finish()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_second -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.exit_app -> {
                showExitConfirmationDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Exit App")
            .setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Exit") { dialog, which ->
                finish() // Close the MainActivity and exit the app
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
