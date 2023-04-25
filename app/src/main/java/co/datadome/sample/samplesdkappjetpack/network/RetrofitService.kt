package co.datadome.sample.samplesdkappjetpack.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RetrofitService {

    @GET("/")
    @Headers("User-Agent: BLOCKUA")
    fun getData(): Call<ResponseBody>
}