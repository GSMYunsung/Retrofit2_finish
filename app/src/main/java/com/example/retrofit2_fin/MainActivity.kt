package com.example.retrofit2_fin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2_fin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , IsCompletionListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var noticeAdapter: BaeminNoticeAdapter
    private lateinit var baeminRepository: Repository
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러뷰 아이템 연결
        binding.baeminNoticeRecyclerview.apply {
            binding.baeminNoticeRecyclerview.layoutManager = LinearLayoutManager(context)
            noticeAdapter = BaeminNoticeAdapter(this@MainActivity)
            binding.baeminNoticeRecyclerview.adapter = noticeAdapter
        }



        //페이지와 콜백 요청
        baeminRepository = Repository()
        baeminRepository.loadBaeminNotice(page,this)

        binding.nextPageLoadingBtn.setOnClickListener {
            baeminRepository.loadBaeminNotice(page++,this)
        }


    }

    // 성공적으로 로드한 경우
    override fun loadComplete(data: Data) {
        Log.d("Data",data.content.toString())
        noticeAdapter.setList(data.content)
        noticeAdapter.notifyDataSetChanged()
    }

    // 응답에 문제가있는 경우
    override fun responseIsNotSuccesful(code: Int) {
        Toast.makeText(this, "사이트가 응답하지 않습니다", Toast.LENGTH_SHORT).show()
        Log.d("로그", code.toString())
    }

    // 로드에 실패한 경우
    override fun loadFail() {
        Toast.makeText(this, "인터넷 연결을 확인하세요", Toast.LENGTH_SHORT).show()
    }

    override fun onclick(data: Content) {
        var thisIntent = Intent(this,ContentActivity::class.java)
        thisIntent.putExtra("DataTitle",data.title)
        thisIntent.putExtra("DataContent",data.content)
        thisIntent.putExtra("DataCreated",data.created)
        startActivity(thisIntent)
    }

}