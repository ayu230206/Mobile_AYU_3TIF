package com.example.ayu_3tif.More

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ayu_3tif.R
import com.example.ayu_3tif.databinding.FragmentMessageBinding
import com.example.ayu_3tif.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

//    private val dataList = listOf(
//        "Kotlin",
//        "Java",
//        "Python",
//        "C++",
//        "JavaScript",
//        "Dart",
//        "Swift",
//        "Go",
//        "Ruby",
//        "R",
//        "PHP",
//        "C#",
//        "TypeScript",
//        "Shell",
//        "SQL",
//        "Perl",
//        "Rust",
//        "Scala",
//        "Haskell",
//        "Lua",
//        "Erlang",
//        "Prolog",
//        "Assembly",
//        "Objective-C",
//        "VBA"
//    )

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami")
    )

    // Mendeklarasikan dataListWithDesc sesuai kebutuhan SimpleAdapter (dikomentari karena dataListWithDesc sudah dideklarasikan di atas)
//    private val dataListWithDesc by lazy {
//        dataList.map { lang ->
//            mapOf("title" to lang, "desc" to "Bahasa Pemrograman $lang")
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "More"
        }

//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )
        //Ubah adapter menjadi seperti berikut
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // Memasang adapter ke ListView agar data muncul di layar
        binding.listViewItems.adapter = adapter

//        binding.listViewItems.adapter = adapter
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem", Toast.LENGTH_SHORT).show()
//        }
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}