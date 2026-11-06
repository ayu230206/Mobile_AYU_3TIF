package com.example.ayu_3tif.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ayu_3tif.Message.MessageModel
import com.example.ayu_3tif.databinding.FragmentMessageBinding
import com.example.ayu_3tif.message.MessageAdapter

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel(
            "Alya",
            "Halo! Apa kabar?",
            "https://avatarapi.runflare.run/public/1",
            "08:15 AM"
        ),
        MessageModel("Budi", "Sudah makan?", "https://avatarapi.runflare.run/public/2", "08:30 AM"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatarapi.runflare.run/public/3", "09:00 AM"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatarapi.runflare.run/public/4", "09:12 AM"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatarapi.runflare.run/public/5", "10:00 AM"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatarapi.runflare.run/public/6", "10:45 AM"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatarapi.runflare.run/public/7", "11:20 AM"),
        MessageModel("Hana", "Lihat email ya", "https://avatarapi.runflare.run/public/8", "01:15 PM"),
        MessageModel("Irfan", "Oke noted", "https://avatarapi.runflare.run/public/9", "02:00 PM"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatarapi.runflare.run/public/10", "03:30 PM")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}