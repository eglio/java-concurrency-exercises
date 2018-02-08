package eglio.sisop;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 08/06/17.
 */
public class ABMain {
    public static void main(String args[]) throws InterruptedException {
        Semaphore stampaAAB= new Semaphore(1);
        while(true){
            Thread a = new AThread();
            stampaAAB.acquire();
            a.start();
            stampaAAB.release();
            TimeUnit.SECONDS.wait(1);
            Thread b= new BThread(stampaAAB);
            b.start();
            TimeUnit.SECONDS.wait(1);
    }}

}
