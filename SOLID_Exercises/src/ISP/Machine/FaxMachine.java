package ISP.Machine;

import ISP.Machine.Faxer;

public class FaxMachine implements Faxer {
    @Override
    public void fax() {
        System.out.println("Faxing");
    }
}
