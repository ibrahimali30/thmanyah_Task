package com.ibrahim.thmanyahTask.modules.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Singleton
    @Named(IODispatcher)
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}

const val IODispatcher = "IODispatcher"