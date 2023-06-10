package com.hindsight.myhexagonalexample.adapter.out.persistence.repository

import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.PurchaseEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository


interface PurchaseRepository: CoroutineCrudRepository<PurchaseEntity, Long>