import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iti_project.CustomAdapter
import com.example.iti_project.FourthActivity
import com.example.iti_project.MyCustomClickListener
import com.example.iti_project.R
import com.example.iti_project.databinding.SecondActivityBinding
import com.example.iti_project.model.Post
import com.example.iti_project.utils.ApiInterface
import com.example.iti_project.utils.RetrofitClient

class SecondActivity : AppCompatActivity(), MyCustomClickListener {

    lateinit var binding: SecondActivityBinding
    lateinit var postsAdapter: CustomAdapter
    lateinit var SharedPref: SharedPreferences
    lateinit var retrofit : ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)

        retrofit = RetrofitClient.getInstance()

        binding.viewPostButton.setOnClickListener {
            lifecycleScope.launchWhenCreated{

                val response = retrofit.getComments(postId)

                if (response.isSuccessful){

                    val comment = response.body()?.get(0)

                    val intent = Intent(this@SecondActivity,FourthActivity::class.java)

                    intent.putExtra("post_id",comment?.PostId)
                    intent.putExtra("comment_id",comment?.id)
                    intent.putExtra("email",comment?.email)
                    intent.putExtra("name",comment?.name)
                    intent.putExtra("body",comment?.body)

                    startActivity(intent)


                }else{
                    Toast.makeText(this@SecondActivity,"error",Toast.LENGTH_LONG).show()
                }
            }
        }

        //binding.welcomeTv.text = "Welcome ${SharedPref.getString("password gamal@gmail.com","")}"

        val postsList = arrayListOf<Post>()
        postsAdapter = CustomAdapter(postsList, this)
        binding.recyclerView.adapter = postsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second_activity, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.logout_menu ->{
                val editor = SharedPref.edit()
                editor.putBoolean("LOGIN",false)
                editor.commit()
                startActivity(Intent(this,MainActivity::class.java))

                finish()
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }
    override fun onItemClick(post: Post, position: Int) {
        Toast.makeText(this,"item num: $position username: ${post.userId}", Toast.LENGTH_SHORT).show()
    }




}




