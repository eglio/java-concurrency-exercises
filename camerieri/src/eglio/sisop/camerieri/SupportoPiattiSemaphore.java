package eglio.sisop.camerieri;

import java.util.concurrent.Semaphore;

/**
 * Created by egliocz on 12/06/17.
 */
public class SupportoPiattiSemaphore {
    private Semaphore mutex;

    public void put(int piattiAggiunti){
        try{
        mutex.acquire(piattiAggiunti);}
        catch(InterruptedException e){e.printStackTrace();}
    };

    public void get(int piattiRimossi){
        mutex.release(piattiRimossi);
    }

    public SupportoPiattiSemaphore(int dimensione){
        mutex=new Semaphore(dimensione);
    }

}
