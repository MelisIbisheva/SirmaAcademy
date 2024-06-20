import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable {
    private List<InventoryItem> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        items.add(item);
    }

    public void removeItemById(String itemId) {
        items.removeIf(item -> item.getItemId().equals(itemId));
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void saveInventory(List<InventoryItem> inventory, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public List<InventoryItem> loadInventory(String fileName) {
        List<InventoryItem> inventory = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            inventory = (List<InventoryItem>) ois.readObject();
            System.out.println("Inventory loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
        return inventory;
    }
}
