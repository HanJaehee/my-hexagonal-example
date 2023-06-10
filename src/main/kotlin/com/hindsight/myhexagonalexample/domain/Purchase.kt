package com.hindsight.myhexagonalexample.domain

data class Purchase(
    val id: Long,
    val productId: Long,
    val amount: Long,
    val buyerId: Long
)
