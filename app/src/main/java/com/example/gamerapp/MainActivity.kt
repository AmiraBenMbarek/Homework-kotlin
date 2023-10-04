package com.example.gamerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnFb = findViewById<ImageButton>(R.id.btnFb)
        val btnGoogle = findViewById<ImageButton>(R.id.btnGoogle)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            try {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("RegisterActivity", "Error starting RegisterActivity", e)
            }
        }

        btnFb.setOnClickListener {
            btnFbGoogle()
        }

        btnGoogle.setOnClickListener {
            btnFbGoogle()
        }


        btnSubmit.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidEmail(email) && isValidPassword(password)) {
            } else {
                if (!isValidEmail(email)) {
                    emailEditText.error = "Invalid email. It should end with @esprit.tn"
                }
                if (!isValidPassword(password)) {
                    passwordEditText.error = "Invalid password"
                }
            }
        }

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }


            override fun afterTextChanged(s: Editable?) {
                val email = s.toString()
                if (!isValidEmail(email)) {
                    emailEditText.error = "Invalid email. It should end with @esprit.tn"
                } else {
                    emailEditText.error = null
                }
            }
        })

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()
                if (!isValidPassword(password)) {
                    passwordEditText.error = "Invalid password. Password must be at least 8 characters"
                } else {
                    passwordEditText.error = null
                }
            }
        })
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.endsWith("@esprit.tn")
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }


    fun btnFbGoogle() {
        val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

        if (isValidEmail(email) && isValidPassword(password)) {
            showSnackbar("Coming soon :)")
        } else {
            showSnackbar("You have some errors in your input")
        }
    }
}