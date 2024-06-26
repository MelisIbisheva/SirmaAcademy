package PaymentProcessing;

// PaymentMethod interface defining methods for payment processing
public interface PaymentMethod {
    boolean validate(); // Method to validate payment details
    boolean authorize(); // Method to authorize payment
}
