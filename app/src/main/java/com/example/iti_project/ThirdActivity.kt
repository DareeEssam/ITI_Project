import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.iti_project.R

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val username = intent.getStringExtra("username")
        val postText = intent.getStringExtra("postText")

        val textView = findViewById<TextView>(R.id.details_textview)
        textView.text = "Username: $username\nPost Text: $postText"
    }
}
