package com.vrrv.work.onlineshopping.store.presentation.products

import com.vrrv.work.onlineshopping.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = true,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
