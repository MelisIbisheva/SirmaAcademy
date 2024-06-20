public class FragileItem extends InventoryItem {
    private double weight;

    public FragileItem(int itemId, String name, String category, boolean breakable, boolean perishable, double price, int quantity, double weight) {
        super(itemId, name, category, breakable, false, price, quantity);
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