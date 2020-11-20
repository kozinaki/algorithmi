package net.kozinaki.fundamenta.structure;

import net.kozinaki.fundamenta.structure.ringbuffer.CircularBuffer;
import net.kozinaki.fundamenta.structure.ringbuffer.CircularBufferImproved;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircleBufferTest {

    @Test
    public void testOffer() {
        CircularBuffer buffer = new CircularBuffer<>(10);

        assertTrue(buffer.offer("Square"));
        assertTrue(buffer.offer("Circle"));
        assertEquals(2, buffer.size());
    }

    @Test
    public void testPoll() {
        CircularBuffer<String> buffer = new CircularBuffer<>(10);
        buffer.offer("Triangle");
        String shape = buffer.poll();

        assertEquals("Triangle", shape);
    }

    @Test
    public void testProducerConsumer() throws ExecutionException, InterruptedException {
        CircularBuffer<String> buffer = new CircularBufferImproved<>(10);
        String[] source = new String[] {"Square", "Triangle", "Circle", "Rectangle", "Kite",
                "Rhombus", "Parallelogram", "Semi-Circle", "Nonagon", "Trapezium"};
        int itemCapacity = 1000;
        String[] items = new String[itemCapacity];
        for (int i = 0; i < items.length; i++) {
            items[i] = source[(int)Math.round(Math.random() * 9)];
        }
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Producer<>(buffer, items));
        Future<String[]> future = executorService.submit( new Consumer<>(buffer, 1000));
        System.out.println(Arrays.toString(future.get()));
    }


    class Producer<T> implements Runnable {

        private CircularBuffer<T> buffer;
        private T[] items;

        public Producer(CircularBuffer<T> buffer, T[] items) {
            this.buffer = buffer;
            this.items = items;
        }

        public void run() {
            for (int i = 0; i < items.length;) {
                if (buffer.offer(items[i])) {
                    System.out.println("Produced: " + items[i]);
                    i++;
                }
            }
        }
    }

    class Consumer<T> implements Callable<T[]> {

        private CircularBuffer<T> buffer;
        private int capacity;

        public Consumer(CircularBuffer<T> buffer, int capacity) {
            this.buffer = buffer;
            this.capacity = capacity;
        }

        @Override
        public T[] call() {
            T[] items = (T[]) new Object[capacity];
            for (int i = 0; i < items.length;) {
                T item = buffer.poll();
                if (item != null) {
                    items[i++] = item;
                    System.out.println("Consumed: " + item);
                }
            }
            return items;
        }
    }

}
