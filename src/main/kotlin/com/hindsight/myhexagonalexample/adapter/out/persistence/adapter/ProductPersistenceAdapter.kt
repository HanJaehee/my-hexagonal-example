package com.hindsight.myhexagonalexample.adapter.out.persistence.adapter

import com.hindsight.myhexagonalexample.adapter.out.persistence.repository.ProductRepository
import com.hindsight.myhexagonalexample.adapter.out.persistence.toDomain
import com.hindsight.myhexagonalexample.common.Adapter
import com.hindsight.myhexagonalexample.domain.Product
import com.hindsight.myhexagonalexample.port.out.LoadProductPort
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

@Adapter
class ProductPersistenceAdapter(
    private val productRepository: ProductRepository
) : LoadProductPort {

    override suspend fun loadProductList(): List<Product> =
        productRepository.findAll().map { it.toDomain() }.toList()


    override suspend fun loadProduct(id: Long): Product? =
        productRepository.findById(id = id)?.toDomain()
}