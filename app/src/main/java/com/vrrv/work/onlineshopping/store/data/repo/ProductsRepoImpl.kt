package com.vrrv.work.onlineshopping.store.data.repo

import arrow.core.Either
import com.vrrv.work.onlineshopping.store.data.mapper.toNetworkError
import com.vrrv.work.onlineshopping.store.data.remote.ProductsApi
import com.vrrv.work.onlineshopping.store.domain.model.NetworkError
import com.vrrv.work.onlineshopping.store.domain.model.Product
import com.vrrv.work.onlineshopping.store.domain.repo.ProductRepo
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(
    private val productsApi: ProductsApi
): ProductRepo {

    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }

}