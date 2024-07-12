package SRP;

import java.util.Date;

public class Invoice {
    private double amount;
    private String customerName;
    private Date date;

    public Invoice(double amount, String customerName, Date date) {
        this.amount = amount;
        this.customerName = customerName;
        this.date = date;
    }

    public void printInvoice(){
        System.out.println(this.amount + " - " + this.customerName + " - " + this.date);
    }
}
