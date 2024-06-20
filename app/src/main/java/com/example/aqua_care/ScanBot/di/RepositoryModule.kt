package com.example.aqua_care.ScanBot.di

import com.example.aqua_care.ScanBot.data.repository.DetectRepositoryImpl
import com.example.aqua_care.ScanBot.domain.DetectRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideDetectRepository(detectRepositoryImpl: DetectRepositoryImpl) : DetectRepository
}