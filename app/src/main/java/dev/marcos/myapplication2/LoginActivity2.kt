package dev.marcos.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dev.marcos.myapplication2.Utils.Navigation

class LoginActivity2 : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        firebaseAuth = FirebaseAuth.getInstance()

        val btnLogin = findViewById<Button>(R.id.submitLoginBtn)
        val emailInput = findViewById<EditText>(R.id.emailInput)  // Corrigido para EditText
        val passwordInput = findViewById<EditText>(R.id.passwordInput) // Corrigido para EditText
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val registerLink = findViewById<TextView>(R.id.create_account)

        btnLogin.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                login(email, password)
            }
        }

        forgotPassword.setOnClickListener {
            Navigation.goToScreen(this, ForgotPasswordActivity::class.java)
        }

        registerLink.setOnClickListener {
            Navigation.goToScreen(this, RegisterActivity::class.java)
        }
    }

    private fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    user?.let {
                        Toast.makeText(this@LoginActivity2, "Seja bem-vindo ${it.email}", Toast.LENGTH_SHORT).show()
                        Navigation.goToScreen(this@LoginActivity2, MainActivity::class.java)
                        finish()  // Fecha a tela de login para impedir que o usuário volte
                    }
                } else {
                    Toast.makeText(this@LoginActivity2, "Falha ao realizar login", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
