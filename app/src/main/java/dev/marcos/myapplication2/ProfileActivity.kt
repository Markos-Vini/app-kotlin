package dev.marcos.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.marcos.myapplication2.Utils.AuthUtils
import dev.marcos.myapplication2.Utils.Navigation

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val homeBtn = findViewById<ImageView>(R.id.home)
        val logoutBtn = findViewById<ImageView>(R.id.logout)
        val saveBtn = findViewById<Button>(R.id.save_btn)

        saveBtn.setOnClickListener {
            Toast.makeText(this, "Perfil salvo", Toast.LENGTH_SHORT).show()
            android.os.Handler().postDelayed({
                Navigation.goToScreen(this, MainActivity::class.java)
            }, 5000)
        }

        homeBtn.setOnClickListener {
            Navigation.goToScreen(this, MainActivity::class.java)
        }

        logoutBtn.setOnClickListener {
            AuthUtils.logout(this);
        }

    }
}