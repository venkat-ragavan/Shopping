package com.vrrv.work.onlineshopping.di

import com.vrrv.work.onlineshopping.store.data.repo.ProductsRepoImpl
import com.vrrv.work.onlineshopping.store.domain.repo.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindProductsRepo(impl: ProductsRepoImpl): ProductRepo

}