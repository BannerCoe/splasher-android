package com.aungmyolwin.splasher.di

import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.data.photos.PhotoRemoteDataSource
import com.aungmyolwin.splasher.data.photos.PhotoRemoteDataSourceImpl
import com.aungmyolwin.splasher.data.photos.PhotoRepository
import com.aungmyolwin.splasher.data.photos.PhotoRepositoryImpl
import com.aungmyolwin.splasher.utils.ParserUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * a touch of amlwin on 2020-01-07.
 * made with <3
 */

@Module
class ShareModule {

    @Singleton
    @Provides
    fun providePhotoRepository(remoteDataSource: PhotoRemoteDataSource): PhotoRepository {
        return PhotoRepositoryImpl(remoteDataSource)
    }

    @Singleton
    @Provides
    fun providePhotoRemoteDataSource(apiService: ApiService): PhotoRemoteDataSource {
        return PhotoRemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideParserUils(): ParserUtils {
        return ParserUtils()
    }
}