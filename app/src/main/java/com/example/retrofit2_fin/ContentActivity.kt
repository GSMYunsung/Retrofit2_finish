package com.example.retrofit2_fin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit2_fin.databinding.ActivityContentBinding
import com.example.retrofit2_fin.databinding.ActivityMainBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val DataTitle = intent.getStringExtra("DataTitle")
        val DataContent = intent.getStringExtra("DataContent")
        val DataCreated = intent.getStringExtra("DataCreated")

        binding.contentText.setText(DataContent)
        binding.mainText.setText(DataTitle)
        binding.timeText.setText(DataCreated)

        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}