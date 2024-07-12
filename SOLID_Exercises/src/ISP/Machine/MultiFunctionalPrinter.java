package ISP.Machine;

public class MultiFunctionalPrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");

    }
}
