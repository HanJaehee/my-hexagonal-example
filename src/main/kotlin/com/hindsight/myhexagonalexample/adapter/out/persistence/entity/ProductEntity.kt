package com.hindsight.myhexagonalexample.adapter.out.persistence.entity

import org.springframework.data.relational.core.mapping.Table

@Table("product")
data class ProductEntity(
    val id: Long? = null,
    val name: String,
    val price: Double
)
