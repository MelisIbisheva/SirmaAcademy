package LSP;

public class Penguin extends Bird{

    public Penguin(int age) {
        super(age);
    }

    @Override
    void eating() {
        System.out.println("Penguin eat fish.");
    }
}
