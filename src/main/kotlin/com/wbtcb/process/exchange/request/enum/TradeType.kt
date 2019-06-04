package com.wbtcb.process.exchange.request.enum

import org.knowm.xchange.dto.Order.OrderType

enum class TradeType(val orderType: OrderType) {
    BUY(OrderType.BID),
    SELL(OrderType.ASK);
}
