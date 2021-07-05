package com.example.retrofit2_fin

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//서버 호출이 필요할때마다 재선언을 해주면 너무 비효율적이기때문에 싱글톤으로 생성한다.
//baseurl : 어디 서버에 요청해줄지? url 에 변하지않는값이 있으면 Base Url이다!

object Client {
    private const val baseUrl = "https://ceo.baemin.com/cms/v1/"
    //addConverterFactory 는 데이터를 파싱할 converter 를 추가하는 메서드이다.
    //Jason 과 같은 데이터는 자바나 코틀린에서 바로 사용할 수 없음! -(converter 변환) - Gson, 등등
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //retrofit 을 통해 인터페이스를 구현!
    val service = retrofit.create(api::class.java)!!

    }