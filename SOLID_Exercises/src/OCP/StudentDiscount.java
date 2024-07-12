package OCP;

public class StudentDiscount implements Discount{
    @Override
    public double calculateDiscount(double price) {
        return price * 0.1;
    }
}
