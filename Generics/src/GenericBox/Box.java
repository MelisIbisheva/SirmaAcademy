package GenericBox;

public class Box <T>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + this.value;

    }
}
