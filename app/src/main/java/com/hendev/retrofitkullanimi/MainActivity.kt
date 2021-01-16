package com.hendev.retrofitkullanimi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kisiSilme(11)
        //kisiEkle("Retro test", "dawd23a22da")
        //kisiGuncelle(13,"Retro Version 2","09006506565")
        //tumKisiler()
        kisiAra("de")
    }

    fun kisiSilme(kisi_id: Int) {
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiSil(kisi_id).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e("Silme Başarılı", response.body().success.toString())
                    Log.e("Silme Mesajı", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Silme Hatası:", t.toString())
            }
        })
    }

    fun kisiEkle(kisi_ad: String, kisi_tel: String) {
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiEkle(kisi_ad, kisi_tel).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e("Ekleme Başarılı", response.body().success.toString())
                    Log.e("Ekleme Mesaj", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Ekleme Hatası", t.toString())
            }
        })
    }

    fun kisiGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiGuncelle(kisi_id,kisi_ad,kisi_tel).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e("Guncelleme Başarılı", response.body().success.toString())
                    Log.e("Guncelleme Mesaj", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Guncelleme Hatası", t.toString())
            }
        })
    }

    fun tumKisiler(){
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.tumKisiler().enqueue(object :Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if (response != null){
                    val kisilerListe = response.body().kisiler
                    for (i in kisilerListe){
                        Log.e("=============","=============")
                        Log.e("Kisi ID ",i.kisiId.toString())
                        Log.e("Kisi Adı ", i.kisiAd)
                        Log.e("Kisi Tel ", i.kisiTel)
                    }
                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
                Log.e("Listeleme Hatası", t.toString())
            }
        })
    }

    fun kisiAra(kisi_ad: String) {
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiAra(kisi_ad).enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if (response != null){
                    val aramaSonucu = response.body().kisiler
                    for (i in aramaSonucu){
                        Log.e("Bulunan Bilgiler",">>>>>>>>>>")
                        Log.e("Kisi ID " , i.kisiId.toString())
                        Log.e("Kisi Adı " , i.kisiAd)
                        Log.e("Kisi Tel " , i.kisiTel)
                    }
                }else{
                    Log.e("Hata","Liste Boş")
                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
                Log.e("Arama Hatası",t.toString())
            }

        })
    }
}