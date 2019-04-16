package com.wbtcb.exchange.request.enum

enum class ExchangeRequestStatus {

    /**
     * Initial state, receive message is valid
     */
    ACCEPTED,

    /**
     * Receive message is not valid
     */
    INVALID,

    /**
     * Start process createMarketOrder
     */
    PENDING,

    /**
     * Process createMarketOrder is success and completed
     */
    COMPLETED,

    /**
     *  Process is cancelled
     */
    CANCELLED,

    REJECTED,

    EXPIRED;
}
