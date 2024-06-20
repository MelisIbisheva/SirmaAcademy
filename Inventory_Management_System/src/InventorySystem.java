import java.util.List;
import java.util.Scanner;

public class InventorySystem {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        removeItem();
                        break;
                    case 3:
                        displayItems();
                        break;
                    case 4:
                        saveInventory();
                        break;
                    case 5:
                        loadInventory();
                        break;
                    case 6:
                        placeOrder();
                        break;
                    case 7:
                        categorizeItems();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("Inventory Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Display Items");
        System.out.println("4. Save Inventory");
        System.out.println("5. Load Inventory");
        System.out.println("6. Place Order");
        System.out.println("7. Categorize Items");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItem() {
        System.out.print("Enter item ID: ");
        int itemId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Is it breakable? (yes/no): ");
        boolean breakable = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Is it perishable? (yes/no): ");
        boolean perishable = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter item type (Grocery/Electronics/Fragile): ");
        String itemType = scanner.nextLine();

        InventoryItem item;
        switch (itemType.toLowerCase()) {
            case "grocery":
                System.out.print("Enter weight: ");
                double weight = Double.parseDouble(scanner.nextLine());
                item = new GroceryItem(itemId, name, category, breakable, perishable,price,quantity, weight);
                break;
            case "electronics":
                System.out.print("Enter warranty period (in months): ");
                int warrantyPeriod = Integer.parseInt(scanner.nextLine());
                item = new ElectronicsItem(itemId, name, category, breakable, perishable, price, quantity, warrantyPeriod);
                break;
            case "fragile":
                System.out.print("Enter weight: ");
                weight = Double.parseDouble(scanner.nextLine());
                item = new FragileItem(itemId, name, category, breakable, perishable, price, quantity, weight);
                break;
            default:
                System.out.println("Invalid item type. Item not added.");
                return;
        }

        inventory.addItem(item);
        System.out.println("Item added successfully.");
    }

    private static void removeItem() {
        System.out.print("Enter item ID to remove: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        inventory.removeItemById(itemId);
        System.out.println("Item removed successfully.");
    }

    private static void displayItems() {
        for (InventoryItem item : inventory.getItems()) {
            System.out.println(item.getItemDetails());
        }
    }

    private static void saveInventory() {
        System.out.print("Enter filename to save inventory: ");
        String filename = scanner.nextLine();
        inventory.saveInventory(inventory.getItems(),filename);
    }

    private static List<InventoryItem> loadInventory() {
        System.out.print("Enter filename to load inventory: ");
        String filename = scanner.nextLine();
        return inventory.loadInventory(filename);
    }

    private static void placeOrder() {
        Order order = new Order();
        while (true) {
            System.out.print("Enter item ID to add to order (or 0 to finish): ");
            int itemId = Integer.parseInt(scanner.nextLine());
            if (itemId==0) {
                break;
            }

            InventoryItem item = inventory.getItems().stream()
                    .filter(i -> i.getItemId()==itemId)
                    .findFirst()
                    .orElse(null);

            if (item == null) {
                System.out.println("Item not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            order.addItem(item, quantity);
            System.out.println("Item added to order.");
        }

        System.out.println(order.getTotalAmount());

        System.out.print("Enter payment amount: ");
        double paymentAmount = Double.parseDouble(scanner.nextLine());
        Payment payment = new Payment(paymentAmount);

        if (payment.processPayment(order.getTotalAmount())) {
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Order placement failed.");
        }
    }

    private static void categorizeItems() {
        System.out.print("Enter item ID to categorize: ");
        int itemId = Integer.parseInt(scanner.nextLine());

        InventoryItem item = inventory.getItems().stream()
                .filter(i -> i.getItemId() == itemId)
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
        
        System.out.print("Enter new category: ");
        String category = scanner.nextLine();
        item.setCategory(category);
        System.out.println("Item categorized successfully.");
    }
}
