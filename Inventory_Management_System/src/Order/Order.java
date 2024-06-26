package Order;
import Inventory.InventoryItem;
import PaymentProcessing.PaymentMethod;
import PaymentProcessing.PaymentProcessor;

import java.util.HashMap;
import java.util.Map;
public class Order {
    private static int idCounter = 1;

    private int orderId;
    private Map<InventoryItem, Integer> items;
    private double totalAmount;
    private PaymentMethod paymentMethod;

    public Order() {
        this.orderId = idCounter++;
        this.items = new HashMap<>();
        this.totalAmount = 0.0;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<InventoryItem, Integer> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(InventoryItem item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
        updateTotalAmount();
    }

    public void removeItem(InventoryItem item) {
        items.remove(item);
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        totalAmount = 0.0;
        for (Map.Entry<InventoryItem, Integer> entry : items.entrySet()) {
            totalAmount += entry.getKey().getPrice() * entry.getValue();
        }
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean processOrder(PaymentProcessor paymentProcessor) {
        if (paymentMethod == null) {
            System.out.println("Payment method not set.");
            return false;
        }

        if (paymentProcessor.processPayment(paymentMethod)) {
            updateInventoryQuantities();
            System.out.println("Order processed successfully.");
            return true;
        } else {
            System.out.println("Order processing failed.");
            return false;
        }
    }

    private void updateInventoryQuantities() {
        for (Map.Entry<InventoryItem, Integer> entry : items.entrySet()) {
            InventoryItem item = entry.getKey();
            int quantity = entry.getValue();
            item.setQuantity(item.getQuantity() - quantity);
        }
    }
}