package co.datadome.sample.samplesdkappjetpack.di

import android.app.Application
import co.datadome.sample.samplesdkappjetpack.BuildConfig
import co.datadome.sample.samplesdkappjetpack.network.RetrofitService
import co.datadome.sdk.DataDomeInterceptor
import co.datadome.sdk.DataDomeSDK
import co.datadome.sdk.DataDomeUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideOkHttpClient(application: Application): OkHttpClient {

        val dataDomeSDK = DataDomeSDK.with(application, "Client_Side_Key", BuildConfig.VERSION_NAME)
            .activateDatadomeLogger(true)

        return OkHttpClient().newBuilder()
            .addInterceptor( DataDomeInterceptor(application, dataDomeSDK))
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofite(okHttpClient: OkHttpClient): RetrofitService {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("base_url")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RetrofitService::class.java)
    }
}