package dev.marcos.myapplication2.Utils

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import dev.marcos.myapplication2.LoginActivity2

class AuthUtils {
    companion object {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance();

        fun logout(context: Context){
            try {
                firebaseAuth.signOut()
                Toast.makeText(context, "Até logo!!!", Toast.LENGTH_SHORT).show()
                Navigation.goToScreen(context, LoginActivity2::class.java)
            } catch (error: Exception) {
                Toast.makeText(context, "Falha ao realizar logout", Toast.LENGTH_SHORT).show()
            }
        }
    }
}