package com.example.solarustask.di

import android.util.Log
import com.example.solarustask.core.data.networking.Constants.Companion.BASE_URL
import com.example.solarustask.features.transactions.data.WebServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor {
                message -> Log.e("api", message) }

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()
    }

    @Provides
    fun provideGsonConvertorFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient,
                        converter:GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(converter)
            .build()
    }
    @Provides
    fun provideWebServices(retrofit: Retrofit): WebServices {
        return retrofit.create(WebServices::class.java)
    }
}