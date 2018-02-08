package eglio.sisop.camerieri;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by egliocz on 12/06/17.
 */
public class SupportoPiattiLC {
    private Lock mutex = new ReentrantLock();
    private Condition nonPieno = mutex.newCondition();
    private Condition nonVuoto = mutex.newCondition();
    private int dimensione;
    private int postiLiberi;

    public void put (int piattiAggiunti){
        try{
            mutex.lock();
            while(postiLiberi<piattiAggiunti){
                nonPieno.await();
            }
            postiLiberi-=piattiAggiunti;
            nonVuoto.signalAll();
        }
        catch(InterruptedException e){e.printStackTrace();}
        finally{mutex.unlock();}
    }

    public void get(int piattiRimossi){
        try {
            mutex.lock();
            while (dimensione == postiLiberi) { //vuoto
                nonVuoto.await();
            }
            postiLiberi+=piattiRimossi;
            nonPieno.signalAll();
        }catch(InterruptedException e){ e.printStackTrace();
        }finally{
            mutex.unlock();
        }
    }


    public SupportoPiattiLC(int dimensione){
        this.dimensione=dimensione;
        this.postiLiberi=dimensione;
    }
}
