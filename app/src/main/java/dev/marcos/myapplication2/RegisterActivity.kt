package dev.marcos.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dev.marcos.myapplication2.Utils.Navigation

class RegisterActivity : AppCompatActivity() {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<Button>(R.id.submitRegisterBtn)
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val loginLink = findViewById<TextView>(R.id.login)

        btnRegister.setOnClickListener {
            val email = findViewById<TextView>(R.id.emailInput).text.toString().trim()
            val password = findViewById<TextView>(R.id.passwordInput).text.toString().trim()

            if (validateInput(email, password)) {
                register(email, password)
            }
        }

        forgotPassword.setOnClickListener {
            Navigation.goToScreen(this, ForgotPasswordActivity::class.java)
        }

        loginLink.setOnClickListener {
            Navigation.goToScreen(this, LoginActivity2::class.java)
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.length < 6) {
            Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun register(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                runOnUiThread {
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Usuário cadastrado com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        Navigation.goToScreen(this, MainActivity::class.java)
                    } else {
                        Toast.makeText(
                            this,
                            "Falha ao registrar usuário: ${task.exception?.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
    }
}
