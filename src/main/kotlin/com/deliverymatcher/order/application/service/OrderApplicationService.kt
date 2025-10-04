package com.deliverymatcher.order.application.service

import com.deliverymatcher.order.application.port.`in`.OrderUseCase
import com.deliverymatcher.order.application.port.out.OrderOutPort
import com.deliverymatcher.order.domain.Order
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class OrderApplicationService (
    private val orderOutPort: OrderOutPort,
) : OrderUseCase {

    @Transactional
    override fun createOrder(order: Order): Order {
        return orderOutPort.save(order)
    }
}