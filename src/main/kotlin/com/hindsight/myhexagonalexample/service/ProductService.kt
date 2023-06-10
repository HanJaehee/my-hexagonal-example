package com.hindsight.myhexagonalexample.service

import com.hindsight.myhexagonalexample.domain.Product
import com.hindsight.myhexagonalexample.port.`in`.ProductGetPort
import com.hindsight.myhexagonalexample.port.out.LoadProductPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val loadProductPort: LoadProductPort) : ProductGetPort {

    @Transactional(readOnly = true)
    override suspend fun getProductList(): List<Product> =
        loadProductPort.loadProductList()

}