package OCP;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    Map<String,Discount> discounts;

    public DiscountCalculator() {
        this.discounts = new HashMap<>();
    }

    public Map<String, Discount> getDiscounts() {
        return discounts;
    }

    public double calculateDiscount(String type, double price){
        Discount discount = discounts.get(type);
        return discount.calculateDiscount(price);
    }
}
