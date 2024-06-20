public class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean processPayment(double totalAmount) {
        if (amount >= totalAmount) {
            System.out.println("Payment of " + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("Insufficient amount. Payment failed.");
            return false;
        }
    }
}
