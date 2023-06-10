package com.hindsight.myhexagonalexample.adapter.`in`.api

import com.hindsight.myhexagonalexample.domain.Product
import com.hindsight.myhexagonalexample.port.`in`.ProductGetPort
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val productGetPort: ProductGetPort
) {

    @GetMapping
    suspend fun getProductList(): ResponseEntity<List<Product>> =
        productGetPort.getProductList()
            .let { ok().body(it) }

}