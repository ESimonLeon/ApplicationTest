package com.example.testapplication.room

import android.content.Context
import androidx.room.Room
import com.example.testapplication.room.dao.TestDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomConfig {

    @Singleton
    @Provides
    fun providerRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "db_test")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun providerHealthDao(appDatabase: AppDatabase): TestDao =
        appDatabase.testDao()

}