package co.datadome.sample.samplesdkappjetpack

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.datadome.sample.samplesdkappjetpack.network.RetrofitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class DataDomeViewModel
@Inject constructor(private val service: RetrofitService)
    : ViewModel() {

    val data: MutableState<String> = mutableStateOf("")

     fun onLoadData() {
         GlobalScope.launch(Dispatchers.IO) {
            val response = service.getData()
            response.enqueue(object: Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    response.body()?.let {
                        data.value = it.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("Error", "An error has occurred at response ${t.localizedMessage}")
                }
            })
        }
    }
}