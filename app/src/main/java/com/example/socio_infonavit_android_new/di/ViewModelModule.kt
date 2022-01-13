package com.example.socio_infonavit_android_new.di

import com.example.socio_infonavit_android_new.repository.MovieRepository
import com.example.socio_infonavit_android_new.repository.MovieRepositoryImpl
import com.example.socio_infonavit_android_new.repository.UserRepository
import com.example.socio_infonavit_android_new.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class UserViewModelModule {

    @Binds
    abstract fun bindRepoImp(repo: UserRepositoryImpl): UserRepository
}

@InstallIn(ViewModelComponent::class)
@Module
abstract class MovieViewModelModule{

    @Binds
    abstract fun bindRepoMovieImpl(repo: MovieRepositoryImpl): MovieRepository
}


