package com.hendev.retrofitkullanimi

class ApiUtils {
    companion object{
        val BASE_URL = "https://jhenimex.000webhostapp.com/"
        fun getKisilerDaoInterface():KisilerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }
}