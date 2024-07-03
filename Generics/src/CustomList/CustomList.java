package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList <T extends Comparable<T>>{
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();

    }

    public List<T> getList() {
        return list;
    }

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index) {
        if (index < 0 || index >= this.list.size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= getList().size() || index2 < 0 || index2 >= getList().size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        T temp = getList().get(index1);
        getList().set(index1, getList().get(index2));
        getList().set(index2, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T e : this.list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T max = this.list.get(0);
        for (T e : this.list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public T getMin() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T min = this.list.get(0);
        for (T e : this.list) {
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;
    }

    public void print() {
        for (T e : this.list) {
            System.out.println(e);
        }
    }
}
