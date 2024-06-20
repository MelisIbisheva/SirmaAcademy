public class InventoryItem extends AbstractItem {
    private String itemId;
    private int quantity;

    public InventoryItem(String itemId, String name, String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, category, breakable, perishable, price);
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getItemDetails() {
        return super.getItemDetails() + ", Item ID: " + itemId + ", Quantity: " + quantity;
    }

    @Override
    public double calculateValue() {
        return getPrice() * quantity;
    }
}