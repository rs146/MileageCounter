package com.peregrine.mileagecounter.di

import android.content.Context
import com.peregrine.mileagecounter.data.MileageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideMileageDatabase(@ApplicationContext context: Context): MileageDatabase =
        MileageDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideMileageDao(mileageDatabase: MileageDatabase) = mileageDatabase.mileageDao()
}