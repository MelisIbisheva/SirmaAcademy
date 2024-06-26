package InterfacesAndAbstactClasses;

import java.time.LocalDate;
// Interface defining methods for perishable items
public interface Perishable {
    // Method to check if the item is perishable
    boolean isPerishable();

    // Method to handle item expiration
    void handleExpiration(LocalDate expiryDate);
}
