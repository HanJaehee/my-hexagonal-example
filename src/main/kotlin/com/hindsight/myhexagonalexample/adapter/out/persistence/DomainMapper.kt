package com.hindsight.myhexagonalexample.adapter.out.persistence

import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.BuyerEntity
import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.ProductEntity
import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.PurchaseEntity
import com.hindsight.myhexagonalexample.domain.Buyer
import com.hindsight.myhexagonalexample.domain.Product
import com.hindsight.myhexagonalexample.domain.Purchase

fun ProductEntity.toDomain(): Product = Product(
    id = this.id ?: throw Exception("정상적이지 않은 엔티티"),
    name = this.name,
    price = this.price
)

fun BuyerEntity.toDomain(): Buyer = Buyer(
    id = this.id ?: throw Exception("정상적이지 않은 엔티티"),
    name = this.name
)

fun PurchaseEntity.toDomain(): Purchase = Purchase(
    id = this.id ?: throw Exception("정상적이지 않은 엔티티"),
    productId = productId,
    amount = amount,
    buyerId = buyerId
)
