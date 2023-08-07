import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iti_project.databinding.SecondActivityBinding
import com.example.iti_project.SecondActivity






class SecondActivity : AppCompatActivity() {

    lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME_KEY")
        val sports = intent.getStringExtra("SPORTS_KEY")
        val gender = intent.getStringExtra("GENDER_KEY")
        val message = "Welcome $username! you like $sports and you are $gender"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
