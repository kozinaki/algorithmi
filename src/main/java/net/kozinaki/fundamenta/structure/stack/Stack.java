package net.kozinaki.fundamenta.structure.stack;

public class Stack<T> {

    private int capacity;
    private T[] data;
    private int head = -1;

    public Stack(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public T pop() {
        if (head < 0 || head >= capacity) {
            return null;
        }
        T value = data[head];
        head--;
        return value;
    }

    public boolean push(T value) {
        if (head >= capacity) {
            return false;
        }
        data[head] = value;
        head++;
        return true;
    }

}
