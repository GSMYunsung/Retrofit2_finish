package com.example.retrofit2_fin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//어떠한 요청을 보내줄지 정해주는 메소드

interface api {

    @GET("contents?typeCode=notice&size=10")
    //동적으로 변해야하는값은 Query 어노테이션으로 지정해준다.
    //페이지를 가져온다.
    fun loadNotice(@Query("page")page : String):Call<baeminData>
}