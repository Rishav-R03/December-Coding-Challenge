import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private final Random random = new Random();

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(random.nextInt(1000));
                int item = queue.take();
                System.out.printf("\t\t\t[%s] Consumed item %d. Remaining queue size: %d\n",Thread.currentThread().getName(),item,queue.size());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted");
        }
    }
}
