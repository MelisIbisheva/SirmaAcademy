package Inventory;

import InterfacesAndAbstractClasses.AbstractItem;

public class InventoryItem extends AbstractItem {
    private int itemId;
    private int quantity;

    public InventoryItem(int itemId, String name, String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(name, category, breakable, perishable, price);
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
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