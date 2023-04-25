package co.datadome.sample.samplesdkappjetpack.repository

import okhttp3.ResponseBody
import retrofit2.Call

interface DataDomeRepository {
    fun getData(): Call<ResponseBody>
}