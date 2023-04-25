package co.datadome.sample.samplesdkappjetpack.repository

import co.datadome.sample.samplesdkappjetpack.network.RetrofitService
import okhttp3.ResponseBody
import retrofit2.Call

class DataDomeRepositoryImplementation
    (private val service: RetrofitService): DataDomeRepository{

    override fun getData(): Call<ResponseBody> {
        return service.getData()
    }

}