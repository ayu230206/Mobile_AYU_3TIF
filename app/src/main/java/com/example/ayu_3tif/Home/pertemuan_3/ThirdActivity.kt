package com.example.ayu_3tif.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ayu_3tif.R
import com.example.ayu_3tif.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inisialisasi komponen
        val inputName: EditText = findViewById(R.id.inputNoTujuan)
        val btnKirim: Button = findViewById(R.id.btnKirim)

        binding.btnKirim.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val number = binding.inputNoTujuan.text
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
            Log.e("Klik btnKirim","Tombol berhasil di tekan. Isi dari inputNoTujuan = $number")

            Toast.makeText(this, "Pesan berhasil dikirim ke :$number ", Toast.LENGTH_SHORT).show()
        }
    }
}