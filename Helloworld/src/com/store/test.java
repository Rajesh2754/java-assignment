package com.store;

public class test {
    public static void main(String[] args) {
        OrderServiceUtil orderService = new OrderServiceUtil();

        try {
            Order order1 = new Order(1, "Rajesh R", 200, "CoD");
            Order order2 = new Order(2, "Mridhula R", 199, "Internet Banking");

            orderService.addOrder(order1);
            orderService.addOrder(order2);

            Order searchedOrder = orderService.searchOrder("1");
            System.out.println("Searched Order: ");
            if (searchedOrder != null) {
                System.out.println("Order ID: " + searchedOrder.getOrderId());
                System.out.println("Customer Name: " + searchedOrder.getCustomerName());
                System.out.println("Order Amount: " + searchedOrder.getOrderAmount());
                System.out.println("Payment Option: " + searchedOrder.getPaymentOption());
            } else {
                System.out.println("Order not found.");
            }

            float totalAmount = orderService.findTotal();
            System.out.println("Total Amount: " + totalAmount);
        } catch (InvalidOrderException e) {
            System.out.println("Invalid Order: " + e.getMessage());
        }
    }
}
