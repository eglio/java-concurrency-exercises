package eglio.sisop;
import java.util.concurrent.Semaphore;
/**
 * Created by egliocz on 08/06/17.
 */
public class BThread extends Thread {
    private Semaphore mutex;

    public BThread(Semaphore s){
        mutex=s;
    }

    public void run() {
        try {
            mutex.acquire();
            System.out.print("B ");
            mutex.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
