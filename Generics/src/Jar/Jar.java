package Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar <T>{
    private Deque<T> jarDeque;

    public Jar() {
        this.jarDeque = new ArrayDeque<>();
    }

    public void addElement(T element){
        this.jarDeque.push(element);

    }

    public T removeElement(){
        return  this.jarDeque.pop();
    }
}
