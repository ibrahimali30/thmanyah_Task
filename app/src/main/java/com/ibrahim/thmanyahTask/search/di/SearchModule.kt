package com.ibrahim.thmanyahTask.search.di

import com.ibrahim.thmanyahTask.search.data.SearchRemoteService
import com.ibrahim.thmanyahTask.search.data.SearchRepositoryImpl
import com.ibrahim.thmanyahTask.search.domain.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import javax.inject.Named

@InstallIn(ViewModelComponent::class)
@Module
object SearchModule {
    @Provides
    @ViewModelScoped
    fun provideSearchRemoteService(@Named("SearchRetrofit") retrofit: Retrofit): SearchRemoteService {
        return retrofit.create(SearchRemoteService::class.java)
    }
}

@InstallIn(ViewModelComponent::class)
@Module
abstract class SearchBindingModule {
    @Binds
    @ViewModelScoped
    abstract fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

}