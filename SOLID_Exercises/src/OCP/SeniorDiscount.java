package OCP;

public class SeniorDiscount implements Discount{
    @Override
    public double calculateDiscount(double price) {
        return price * 0.2;
    }
}
