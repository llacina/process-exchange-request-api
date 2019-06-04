package com.wbtcb.process.exchange.request.enum

enum class ExchangeRequestStatus {

    /**
     * Initial state, receive message
     */
    CREATED,

    /**
     * Receive message is valid
     */
    VALID,

    /**
     * Receive message is not valid
     */
    INVALID,

    /**
     * Start claim process
     */
    TO_CLAIM,

    /**
     * Claimed
     */
    CLAIMED,

    /**
     * Start payment process
     */
    TO_PAY,

    /**
     *
     */
    PAID
}
