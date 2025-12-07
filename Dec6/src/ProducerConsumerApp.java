import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerConsumerApp {
    //1. The shared, thread-safe queue (The Buffer)
    // Capacity of 10 items
    private static final int CAPACITY = 10;
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(CAPACITY);

    static void main(String [] args){
        System.out.println("Starting Producer-Consumer Application with a shared Blocking Queue");

        //2. Create and start the Producer thread
        Thread producerThread = new Thread(new Producer(queue),"Producer-Thread");
        producerThread.start();

        //3. Create and start consumer thread
        Thread consumerThread = new Thread(new Consumer(queue),"Consumer-Thread");
        consumerThread.start();
    }
}
