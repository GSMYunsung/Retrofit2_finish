package com.example.retrofit2_fin

interface IsCompletionListener {
        fun loadComplete(data: Data)
        fun responseIsNotSuccesful(code: Int)
        fun loadFail()
}