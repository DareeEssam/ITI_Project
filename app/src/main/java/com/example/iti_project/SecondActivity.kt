import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iti_project.CustomAdapter
import com.example.iti_project.Posts
import com.example.iti_project.R
import com.example.iti_project.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: SecondActivityBinding
    lateinit var postsAdapter: CustomAdapter
    lateinit var SharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)

        binding.welcomeTv.text = "Welcome ${SharedPref.getString("password gamal@gmail.com","")}"

        val postsList = posts()
        postsAdapter = CustomAdapter(postsList)
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
    fun onItemClick(post: Posts, position: Int) {
        Toast.makeText(this,"item num: $position username: ${post.UserName}", Toast.LENGTH_SHORT).show()
    }


    fun posts(): List<Posts> {
        return listOf(
            Posts("Title 1", "Dareen Essam", "7/8/2023", "This is my first post here"),
            Posts("Title 2", "Nada Ahmed", "7/8/2023", "Hello Every One"),

        )
    }
}



