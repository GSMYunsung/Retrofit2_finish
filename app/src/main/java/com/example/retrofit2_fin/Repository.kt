package com.example.retrofit2_fin

import android.telecom.Call
import android.util.Log
import retrofit2.Response
import javax.security.auth.callback.Callback

// 요청을 보내고 응답을 받는부분

class Repository {

    fun loadBaeminNotice(page:Int,callback:MainActivity){
        val call = Client.service.loadNotice(page.toString())

        //비동기방식으로 요청을 보낸다.
        call.enqueue(object : retrofit2.Callback<baeminData> {
            override fun onResponse(call : retrofit2.Call<baeminData>, repository: Response<baeminData>){
                if(repository.isSuccessful()){ // 응답을 잘 받은 경우
                    //응답을 잘 받았을경우 repositroy 부분에 data에 들어갔을거기 때문에 값을 보내준다.
                    callback.loadComplete(repository.body()!!.data)
                    Log.d("CallData",repository.body()!!.data.toString())
                }
                else
                {
                // 통신은 성공했지만 응답에 문제가 있는 경우
                }
            }

            override fun onFailure(call: retrofit2.Call<baeminData>, t: Throwable) {
                //통신에 실패했을경우
            }
        })
    }
}