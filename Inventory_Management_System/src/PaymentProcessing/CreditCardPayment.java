package PaymentProcessing;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Method to validate credit card payment details
    @Override
    public boolean validate() {
        // Validate credit card number, expiry date, and CVV
        return cardNumber != null && cardNumber.matches("\\d{16}") &&
                expiryDate != null && expiryDate.matches("\\d{2}/\\d{2}") &&
                cvv != null && cvv.matches("\\d{3}");
    }

    // Method to authorize credit card payment
    @Override
    public boolean authorize() {
        // Simulate authorization logic
        System.out.println("Authorizing credit card payment...");
        return true; // Simulate successful authorization
    }
}
