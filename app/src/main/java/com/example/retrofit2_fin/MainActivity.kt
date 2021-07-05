package com.example.retrofit2_fin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit2_fin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , IsCompletionListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.baeminNoticeRecyclerview.apply {

        }


    }

    // 성공적으로 로드한 경우
    override fun loadComplete(data: Data) {
        TODO("Not yet implemented")
    }

    // 응답에 문제가있는 경우
    override fun responseIsNotSuccesful(code: Int) {
        TODO("Not yet implemented")
    }

    // 로드에 실패한 경우
    override fun loadFail() {
        TODO("Not yet implemented")
    }
}