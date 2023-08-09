import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iti_project.CustomAdapter
import com.example.iti_project.Posts
import com.example.iti_project.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: SecondActivityBinding
    lateinit var postsAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postsList = posts()
        postsAdapter = CustomAdapter(postsList)
        binding.recyclerView.adapter = postsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun posts(): List<Posts> {
        return listOf(
            Posts("Title 1", "Dareen Essam", "7/8/2023", "This is my first post here"),
            Posts("Title 2", "Nada Ahmed", "7/8/2023", "Hello Every One"),

        )
    }
}


