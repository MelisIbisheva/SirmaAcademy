public class GroceryItem extends InventoryItem {
    private double weight;

    public GroceryItem(String itemId, String name, double price, int quantity, String category, boolean breakable, boolean perishable, double weight) {
        super(itemId, name, category, breakable, perishable, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity() * weight;
    }

    @Override
    public String getItemDetails() {
        return super.getItemDetails() + ", Weight: " + weight + " kg";
    }
}
