package com.deliverymatcher.order.application.port.out

import com.deliverymatcher.order.domain.Order

interface OrderOutPort {
    fun save(order: Order): Order
}