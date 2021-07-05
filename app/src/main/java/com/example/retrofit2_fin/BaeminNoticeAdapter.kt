package com.example.retrofit2_fin

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2_fin.databinding.BaeminNoticeItemBinding

class BaeminNoticeAdapter : RecyclerView.Adapter<BaeminNoticeAdapter.NoticeViewHolder>() {
    inner class NoticeViewHolder(private val binding : BaeminNoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notice : Content){
            binding.mainText.text = notice.title
            binding.dateText.text = notice.created.substring(0,10) // 처음과 끝 인덱스를 가져온다. 날짜가 딱 10까지!
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}