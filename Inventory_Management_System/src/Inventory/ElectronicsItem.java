package Inventory;

public class ElectronicsItem extends InventoryItem {
    private int warrantyPeriod; // in months

    public ElectronicsItem(int itemId, String name, String category, boolean breakable, boolean perishable, double price, int quantity, int warrantyPeriod) {
        super(itemId, name, category, breakable, false, price, quantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity();
    }

    @Override
    public String getItemDetails() {
        return super.getItemDetails() + ", Warranty Period: " + warrantyPeriod + " months";
    }
}