import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private final Random random = new Random();

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        try{
            int i = 0;
            while(true){
                int item = i++;
                System.out.printf("[%s] Producing item %d. Current queue size: %d\n",Thread.currentThread().getName(),item,queue.size());
                queue.put(item);
                Thread.sleep(random.nextInt(300));
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted");
        }
    }
}
