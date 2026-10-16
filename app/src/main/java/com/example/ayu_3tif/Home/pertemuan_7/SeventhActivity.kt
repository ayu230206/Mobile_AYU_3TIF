package com.example.ayu_3tif.Home.pertemuan_7

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.ayu_3tif.R
import com.example.ayu_3tif.databinding.ActivitySeventhBinding // Import ViewBinding

class SeventhActivity : AppCompatActivity() {

    // 1. Tipe data binding harus menggunakan kelas binding dari layout (misal: ActivitySeventhBinding)
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 2. Inisialisasi View Binding dengan benar
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root) // Gunakan binding.root
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        // Menampilkan fragment pertama secara default
        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        menjalankan action di setiap menu
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
//    menampilkan fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
//            untuk kembali ke kestack sbelumnya kalo ga pake ini maka akan lngsung kembali ke activity sebelumnya
            .addToBackStack(null)
            .commit()
    }
}