package ua.motionman.recyclerviewlecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ua.motionman.recyclerviewlecture.basicadapter.ChatAdapter
import ua.motionman.recyclerviewlecture.databinding.ActivityMainBinding
import ua.motionman.recyclerviewlecture.helper.messages

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()
        baseAdapter.messages = messages
    }

    fun initAdapter() {
        binding.recyclerViewContainer.apply {
            adapter = baseAdapter
        }
    }
}