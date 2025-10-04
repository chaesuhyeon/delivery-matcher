package com.deliverymatcher.order.adapter.out.repository

import com.deliverymatcher.order.adapter.out.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository : JpaRepository<OrderEntity, Long>