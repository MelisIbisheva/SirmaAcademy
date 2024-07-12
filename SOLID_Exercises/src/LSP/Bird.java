package LSP;

public abstract class Bird {
    private int Age;

    public Bird(int age) {
        Age = age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    abstract void  eating();
}
