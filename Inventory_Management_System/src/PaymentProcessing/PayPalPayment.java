package PaymentProcessing;

public class PayPalPayment implements PaymentMethod {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Method to validate PayPal payment details
    @Override
    public boolean validate() {
        // Validate email and password
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
                password != null && password.length() >= 6;
    }

    // Method to authorize PayPal payment
    @Override
    public boolean authorize() {
        // Simulate authorization logic
        System.out.println("Authorizing PayPal payment...");
        return true; // Simulate successful authorization
    }
}