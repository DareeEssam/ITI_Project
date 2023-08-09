import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.iti_project.R
import com.example.iti_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var SharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        SharedPref= applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)

        binding.usernameEt.setText(SharedPref.getString("USERNAME",""))
        binding.passwordEt.setText(SharedPref.getString("PASSWORD",""))



        binding.loginBt.setOnClickListener {

            val editor = SharedPref.edit()

            editor.putString("USERNAME ${binding.usernameEt.text.toString()}" ,binding.usernameEt.text.toString())
            editor.putString("PASSWORD ${binding.usernameEt.text.toString()}",binding.passwordEt.text.toString())
            editor.putBoolean("LOGIN",true)
            editor.commit()



            val username = binding.usernameEt.text.toString()

            var sports = ""
            var gender = ""

            if (binding.footballCk.isChecked) {
                sports += "Football "
            }
            if (binding.basketballCk.isChecked) {
                sports += "Basketball "
            }
            if (binding.volleyballCk.isChecked) {
                sports += "Volleyball "
            }

            gender = if (binding.maleRb.isChecked) {
                "Male"
            } else {
                "Female"
            }

            // Show the Toast with user information
            Toast.makeText(this, "Hello $username you like $sports and you are $gender", Toast.LENGTH_LONG).show()

            // Start SecondActivity and pass the username as an extra
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USERNAME_KEY", username)
            intent.putExtra("SPORTS_KEY", sports)
            intent.putExtra("GENDER_KEY", gender)
            startActivity(intent)
        }
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
