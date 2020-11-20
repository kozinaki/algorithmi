package net.kozinaki.fundamenta.structure.ringbuffer;

/**
 * Ring buffer implementation
 * @param <T>
 */
public class CircularBuffer<T> {

    private final int capacity;
    private final T[] data;
    private int readSequence;
    private int writeSequence;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.readSequence = 0;
        this.writeSequence = -1;
    }

    /**
     * Add element if there is empty slot
     * @param element to add to buffer
     * @return false if there is not empty slot
     */
    public boolean offer(T element) {
        boolean isFull = (getWriteSequence() - getReadSequence()) + 1 == capacity;
        if (!isFull) {
            int nextWriteSeq = getWriteSequence() + 1;
            data[nextWriteSeq % capacity] = element;
            incrementWriteSequence();
            return true;
        }
        return false;
    }

    /**
     * Retrieve and remove next element
     * @return optional with a possible value
     */
    public T poll() {
        boolean isEmpty = getWriteSequence() < getReadSequence();
        if (!isEmpty) {
            T nextValue = data[getReadSequence() % capacity];
            incrementReadSequence();
            return nextValue;
        }
        return null;
    }

    public int size() {
        return (getWriteSequence() - getReadSequence()) + 1;
    }

    protected int getWriteSequence() {
        return writeSequence;
    }

    protected int getReadSequence() {
        return readSequence;
    }

    protected void incrementWriteSequence() {
        writeSequence++;
    }

    protected void incrementReadSequence() {
        readSequence++;
    }

}
