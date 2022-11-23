package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.data.local.Storage
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storage = Storage.getInctance(this)
        binding.save.setOnClickListener {
            binding.editText.text.toString().apply {
                if (this.isNotEmpty()) {
                    storage.save(this)
                } else {
                    Toast.makeText(this@MainActivity, "Enter the text", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.show.setOnClickListener{
            val t = storage.get()
            if (t.isEmpty()){
                binding.text.text = "Empty"
            }else{
                binding.text.text = t
            }
        }
    }
}

