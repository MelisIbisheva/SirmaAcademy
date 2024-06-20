import java.time.LocalDate;

public interface Perishable {
    boolean isPerishable();
    void handleExpiration(LocalDate expiryDate);
}
