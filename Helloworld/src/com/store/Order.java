package com.store;

class Order {
    private int orderId;
    private String customerName;
    private float orderAmount;
    private String paymentOption;

    public Order(int orderId, String customerName, float orderAmount, String paymentOption) throws InvalidOrderException {
        if (orderAmount < 100) {
            throw new InvalidOrderException("orderAmount should not be less than 100");
        }

        if (!paymentOption.equals("CoD") && !paymentOption.equals("Gift Card") && !paymentOption.equals("Internet Banking")) {
            throw new InvalidOrderException("Invalid paymentOption");
        }

        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
        this.paymentOption = paymentOption;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public String getPaymentOption() {
        return paymentOption;
    }
}