import java.util.LinkedList;

class PC {
    // Shared buffer
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2; // fixed capacity as per example

    // Producer method
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // If buffer is full, producer waits
                while (list.size() == capacity) {
                    wait();
                }
                
                // Add item to buffer
                list.add(value);
                System.out.println("Producer produced-" + value);
                value++;
                
                // Notify consumer that an item is available
                notify();
            }
            Thread.sleep(1000); // sleep 1 second
        }
    }

    // Consumer method
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // If buffer is empty, consumer waits
                while (list.size() == 0) {
                    wait();
                }
                
                // Remove item from buffer
                int val = list.removeFirst();
                System.out.println("Consumer consumed-" + val);
                
                // Notify producer that space is available
                notify();
            }
            Thread.sleep(1000); // sleep 1 second
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        PC pc = new PC();
        
        // Producer Thread
        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Consumer Thread
        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        producerThread.start();
        consumerThread.start();
        
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}