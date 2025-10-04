package com.deliverymatcher.order.application.port.`in`

import com.deliverymatcher.order.domain.Order

interface OrderUseCase {
    fun createOrder(order: Order): Order
}