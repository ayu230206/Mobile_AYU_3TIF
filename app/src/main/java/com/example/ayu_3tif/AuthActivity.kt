package com.example.ayu_3tif

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ayu_3tif.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isNotEmpty() && username == password) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                var intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Peringatan")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("Ya") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }
}