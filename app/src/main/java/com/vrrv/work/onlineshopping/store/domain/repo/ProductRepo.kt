package com.vrrv.work.onlineshopping.store.domain.repo

import arrow.core.Either
import com.vrrv.work.onlineshopping.store.domain.model.NetworkError
import com.vrrv.work.onlineshopping.store.domain.model.Product

interface ProductRepo {

    suspend fun getProducts(): Either<NetworkError, List<Product>>
}