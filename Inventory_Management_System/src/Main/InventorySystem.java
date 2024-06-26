package Main;

import Inventory.*;
import Order.Order;
import PaymentProcessing.CreditCardPayment;
import PaymentProcessing.PayPalPayment;
import PaymentProcessing.PaymentMethod;
import PaymentProcessing.PaymentProcessor;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Inventory.InventoryItem;

public class InventorySystem {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);
    private static List<InventoryItem> cart = new ArrayList<>();


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
                        addToCart();
                        break;
                    case 7:
                        viewCart();
                        break;
                    case 8:
                        placeOrder();
                        break;
                    case 9:
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
        System.out.println("6. Add Item to Cart");
        System.out.println("7. View Cart");
        System.out.println("8. Place Order");
        System.out.println("9. Categorize Items");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItem() {
        // Code for adding an item to the inventory
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
        // Code for removing an item from the inventory
        System.out.print("Enter item ID to remove: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        inventory.removeItemById(itemId);
        System.out.println("Item removed successfully.");
    }

    private static void displayItems() {
        // Code for displaying items in the inventory
        for (InventoryItem item : inventory.getItems()) {
            System.out.println(item.getItemDetails());
        }
    }

    private static void saveInventory() {
        // Code for saving the inventory to a file
        System.out.print("Enter filename to save inventory: ");
        String filename = scanner.nextLine();
        inventory.saveInventory(inventory.getItems(),filename);
    }

    private static List<InventoryItem> loadInventory() {
        // Code for loading the inventory from a file
        System.out.print("Enter filename to load inventory: ");
        String filename = scanner.nextLine();
        return inventory.loadInventory(filename);
    }

    private static void addToCart() {
        // New method to add an item to the cart
        displayItems();
        System.out.print("Enter the item ID to add to the cart: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        InventoryItem item = inventory.getItemById(itemId);

        if (item != null) {
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= item.getQuantity()) {
                for (int i = 0; i < quantity; i++) {
                    cart.add(item);
                }
                item.setQuantity(item.getQuantity() - quantity);
                System.out.println("Item added to cart.");
            } else {
                System.out.println("Insufficient stock. Only " + item.getQuantity() + " available.");
            }
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void viewCart() {
        // New method to view the items in the cart
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (InventoryItem item : cart) {
                System.out.println(item.getItemDetails());
            }
        }
    }

    private static void placeOrder() {
        // method to place an order
        Order order = new Order();
        for (InventoryItem item : cart) {
            order.addItem(item, 1);
        }

        System.out.println("Order Total: " + order.getTotalAmount()          );
        System.out.print("Choose payment method (1: Credit Card, 2: PayPal): ");
        int paymentChoice = Integer.parseInt(scanner.nextLine());

        PaymentMethod paymentMethod = null;
        switch (paymentChoice) {
            case 1:
                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter expiry date: ");
                String expiryDate = scanner.nextLine();
                System.out.print("Enter CVV: ");
                String cvv = scanner.nextLine();
                paymentMethod = new CreditCardPayment(cardNumber, expiryDate, cvv);
                break;
            case 2:
                System.out.print("Enter PayPal email: ");
                String email = scanner.nextLine();
                System.out.print("Enter PayPal password: ");
                String password = scanner.nextLine();
                paymentMethod = new PayPalPayment(email, password);
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }

        order.setPaymentMethod(paymentMethod);
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        if (order.processOrder(paymentProcessor)) {
            cart.clear();
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Order placement failed.");
        }
    }
    private static void categorizeItems() {
        // Code for categorizing an item in the inventory
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
