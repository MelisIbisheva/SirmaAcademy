package LSP;

public class Owl extends Bird implements Flyable{
    public Owl(int age) {
        super(age);
    }

    @Override
    void eating() {

        System.out.println("The owl eat small animals.");
    }

    @Override
    public void fly() {
        System.out.println("Owl is flying.");
    }
}
