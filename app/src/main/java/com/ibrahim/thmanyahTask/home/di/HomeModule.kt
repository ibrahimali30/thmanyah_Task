package com.ibrahim.thmanyahTask.home.di

import com.ibrahim.thmanyahTask.home.data.HomeRemoteService
import com.ibrahim.thmanyahTask.home.data.HomeRepositoryImpl
import com.ibrahim.thmanyahTask.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
object HomeModule {
    @Provides
    @ViewModelScoped
    fun provideHomeRemoteService(retrofit: Retrofit): HomeRemoteService {
        return retrofit.create(HomeRemoteService::class.java)
    }
}

@InstallIn(ViewModelComponent::class)
@Module
abstract class HomeBindingModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository

}