package Inventory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Order.Order;


public class Inventory implements Serializable {
    private List<InventoryItem> items;
    private  List<Order> ordes;

    public Inventory() {
        items = new ArrayList<>();
        ordes = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        this.items.add(item);
    }

    public void removeItemById(int itemId) {
        this.items.removeIf(item -> item.getItemId()==itemId);
    }
    public InventoryItem getItemById(int itemId) {
        for (InventoryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null; // or throw an exception if preferred
    }

    // Method to get all items in the inventory
    public List<InventoryItem> getItems() {
        return this.items;
    }

    public List<Order> getOrdes() {
        return this.ordes;
    }
    public void addOrder (Order order){
        this.ordes.add(order);
    }

    // Method to save the inventory to a file
    public void saveInventory(List<InventoryItem> inventory, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Method to load the inventory from a file
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
