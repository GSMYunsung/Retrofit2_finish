package com.example.retrofit2_fin

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2_fin.databinding.BaeminNoticeItemBinding

class BaeminNoticeAdapter(val listener: IsCompletionListener) : RecyclerView.Adapter<BaeminNoticeAdapter.NoticeViewHolder>() {
    private var items = ArrayList<Content>()

    inner class NoticeViewHolder(private val binding : BaeminNoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notice : Content){
            binding.mainText.text = notice.title
            binding.dateText.text = notice.created.substring(0,10) // 처음과 끝 인덱스를 가져온다. 날짜가 딱 10까지!
        }
        fun onclick(notice: Content){
            listener.onclick(notice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BaeminNoticeItemBinding.inflate(layoutInflater,parent,false)

        return NoticeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            holder.onclick(items[position])
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // 가져온 아이템 items 변수에 넣어주기
    fun setList(notice: ArrayList<Content>) {
        items = notice
    }
}