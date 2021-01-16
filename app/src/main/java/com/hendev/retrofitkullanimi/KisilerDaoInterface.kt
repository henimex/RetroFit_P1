package com.hendev.retrofitkullanimi

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDaoInterface {

    @POST("services/delete_kisiler.php")
    @FormUrlEncoded
    fun kisiSil(@Field("kisi_id") kisi_id: Int): Call<CRUDCevap>

    @POST("services/insert_kisiler.php")
    @FormUrlEncoded
    fun kisiEkle(
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @POST("services/update_kisiler.php")
    @FormUrlEncoded
    fun kisiGuncelle(
        @Field("kisi_id") kisi_id: Int,
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @GET("services/tum_kisiler.php")
    fun tumKisiler():Call<KisilerCevap>

    @POST("services/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun kisiAra(@Field("kisi_ad") kisi_ad: String): Call<KisilerCevap>
}