package InterfacesAndAbstactClasses;

import InterfacesAndAbstactClasses.Breakable;
import InterfacesAndAbstactClasses.Categorizable;
import InterfacesAndAbstactClasses.Perishable;
import InterfacesAndAbstactClasses.Sellable;
import InterfacesAndAbstractClasses.Item;

import java.time.LocalDate;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    private String name;
    private String category;
    private boolean breakable;
    private boolean perishable;
    private double price;

    public AbstractItem(String name, String category, boolean breakable, boolean perishable, double price) {
        this.name = name;
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.price = price;
    }

    @Override
    public String getItemDetails() {
        return "Name: " + name + ", Category: " + category + ", Price: " + price;
    }


    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public void handleBreakage() {
        if (breakable) {
            System.out.println(name + " has broken.");
        }
    }

    @Override
    public boolean isPerishable() {
        return perishable;
    }



    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double calculateValue() {
        return 0;
    }

    @Override
    public void displayDescription() {

    }

    @Override
    public void handleExpiration(LocalDate expiryDate) {
        if (perishable) {
            System.out.println(name + " has expired.");
        }

    }
}