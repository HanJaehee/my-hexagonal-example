package com.hindsight.myhexagonalexample.adapter.out.persistence.repository

import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.ProductEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ProductRepository: CoroutineCrudRepository<ProductEntity, Long>