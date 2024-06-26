package PaymentProcessing;

public class PaymentProcessor {
    /**
     * Processes a payment using the given payment method.
     *
     * @param paymentMethod The payment method to use for the transaction.
     * @return true if the payment is authorized, false otherwise.
     */
    public boolean processPayment(PaymentMethod paymentMethod) {
        if (paymentMethod.validate()) { // Validate payment method details
            System.out.println("Processing payment...");
            boolean authorized = paymentMethod.authorize(); // Attempt to authorize payment
            if (authorized) {
                System.out.println("Payment authorized.");
                return true;
            } else {
                System.out.println("Payment authorization failed.");
                return false;
            }
        } else {
            System.out.println("Invalid payment details."); // Handle invalid payment details
            return false;
        }
    }
}
