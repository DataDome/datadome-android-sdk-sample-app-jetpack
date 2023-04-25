package co.datadome.sample.samplesdkappjetpack.di

import co.datadome.sample.samplesdkappjetpack.network.RetrofitService
import co.datadome.sample.samplesdkappjetpack.repository.DataDomeRepository
import co.datadome.sample.samplesdkappjetpack.repository.DataDomeRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesDataDomeRepository(service: RetrofitService): DataDomeRepository {
        return DataDomeRepositoryImplementation(service)
    }
}