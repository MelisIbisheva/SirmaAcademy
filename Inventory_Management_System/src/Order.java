import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<InventoryItem, Integer> items;
    private double totalAmount;

    public Order() {
        items = new HashMap<>();
        totalAmount = 0.0;
    }

    public void addItem(InventoryItem item, int quantity) {
        if (item.getQuantity() >= quantity) {
            items.put(item, quantity);
            totalAmount += item.getPrice() * quantity;
            item.setQuantity(item.getQuantity() - quantity);
        } else {
            System.out.println("Insufficient stock for item: " + item.getItemId());
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}