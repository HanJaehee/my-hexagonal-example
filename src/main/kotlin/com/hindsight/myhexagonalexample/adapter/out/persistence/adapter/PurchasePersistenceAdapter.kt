package com.hindsight.myhexagonalexample.adapter.out.persistence.adapter

import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.PurchaseEntity
import com.hindsight.myhexagonalexample.adapter.out.persistence.repository.PurchaseRepository
import com.hindsight.myhexagonalexample.adapter.out.persistence.toDomain
import com.hindsight.myhexagonalexample.common.Adapter
import com.hindsight.myhexagonalexample.domain.Purchase
import com.hindsight.myhexagonalexample.port.out.CreatePurchasePort
import com.hindsight.myhexagonalexample.port.out.LoadPurchasePort
import com.hindsight.myhexagonalexample.port.out.UpdatePurchasePort

@Adapter
class PurchasePersistenceAdapter(
    private val purchaseRepository: PurchaseRepository
) : CreatePurchasePort, LoadPurchasePort, UpdatePurchasePort {

    override suspend fun createPurchase(productId: Long, amount: Long, buyerId: Long): Purchase =
        purchaseRepository.save(
            PurchaseEntity(
                productId = productId,
                amount = amount,
                buyerId = buyerId
            )
        ).toDomain()


    override suspend fun loadPurchase(id: Long): Purchase? =
        purchaseRepository.findById(id = id)?.toDomain()

    override suspend fun updatePurchase(purchase: Purchase): Purchase {
        // adapter에선 단순 CRUD만, 비즈니스 로직이 담긴 수정은 서비스에서 처리한다.
        // 구매 엔티티를 확인하고 수정하는것도 비즈니스로직 아닐까
        val purchaseEntity: PurchaseEntity =
            purchaseRepository.findById(id = purchase.id) ?: throw Exception("구매 정보 없음")

        return purchaseRepository.save(
            purchaseEntity.copy(
                productId = purchase.productId,
                amount = purchase.amount,
                buyerId = purchase.buyerId
            )
        ).toDomain()
    }

}