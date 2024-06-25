package com.example.aqua_care.Berita.Retrofit

import androidx.lifecycle.MutableLiveData
import com.example.aqua_care.Berita.Model.Post
import retrofit2.HttpException

class BeritaRepository {
    private val api: BeritaApi = RetrofitInstansi.api

    val latestNews = MutableLiveData<List<Post>>()

    suspend fun getLatestNews() {
        try {
            val response = api.getLatestNews()
            if (response.success) {
                latestNews.postValue(response.data.posts)
            } else {
                latestNews.postValue(emptyList())
            }
        } catch (e: HttpException) {
            latestNews.postValue(emptyList())
        } catch (e: Throwable) {
            latestNews.postValue(emptyList())
        }
    }
}
