package com.store;

public class OrderServiceUtil {
    private Order[] orders;
    private int count;

    public OrderServiceUtil() {
        orders = new Order[10];
        count = 0;
    }

    public void addOrder(Order order) {
        orders[count] = order;
        count++;
    }

    public Order searchOrder(String orderId) {
        for (int i = 0; i < count; i++) {
            if (String.valueOf(orders[i].getOrderId()).equals(orderId)) {
                return orders[i];
            }
        }

        return null;
    }

    public float findTotal() {
        float totalAmount = 0;

        for (int i = 0; i < count; i++) {
            totalAmount += orders[i].getOrderAmount();
        }

        return totalAmount;
    }
}
