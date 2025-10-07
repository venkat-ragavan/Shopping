package com.vrrv.work.onlineshopping.store.data.remote

import com.vrrv.work.onlineshopping.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}