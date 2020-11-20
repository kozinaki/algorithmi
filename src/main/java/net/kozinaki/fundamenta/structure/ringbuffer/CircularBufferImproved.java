package net.kozinaki.fundamenta.structure.ringbuffer;

/**
 * Improved version of {@link CircularBuffer} by thread-safe tweaks
 * @param <T>
 */
public class CircularBufferImproved<T> extends CircularBuffer<T> {

    private volatile int readSequence;
    private volatile int writeSequence;

    public CircularBufferImproved(int capacity) {
        super(capacity);
    }

    @Override
    protected int getWriteSequence() {
        return writeSequence;
    }

    @Override
    protected int getReadSequence() {
        return readSequence;
    }

    @Override
    protected void incrementWriteSequence() {
        writeSequence++;
    }

    @Override
    protected void incrementReadSequence() {
        readSequence++;
    }
}
