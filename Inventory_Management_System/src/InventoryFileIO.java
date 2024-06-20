import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryFileIO {
    private static final String FILENAME = "inventory.txt";

    public void saveInventory(List<InventoryItem> inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public List<InventoryItem> loadInventory() {
        List<InventoryItem> inventory = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            inventory = (List<InventoryItem>) ois.readObject();
            System.out.println("Inventory loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
        return inventory;
    }
}
