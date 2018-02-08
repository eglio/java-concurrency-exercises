package eglio.sisop.prove.casello;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egliocz on 08/06/17.
 */
public class Porta {
    private LinkedList<Veicolo> veicoli;
    private float incassoPorta = 0;
    private Semaphore mutex;
    private Lock lock = new ReentrantLock(true);
    private float T; //tariffa oraria
    private Random r = new Random();

    public Porta(float T) {
        veicoli = new LinkedList<Veicolo>();
        mutex = new Semaphore(1);
        this.T = T;
    }

    public float getIncassoPorta() {
        return incassoPorta;
    }

    public void accoda(Veicolo v) throws InterruptedException {
        System.out.println("veicolo accodato");
        mutex.acquire();
        veicoli.add(v);
        mutex.release();
    }

    public void pagaEAbbandona(Veicolo v, int x) {
        try {
            lock.lock();
            incassoPorta += x * T;
            int attesa = (3+r.nextInt(3))*1000; //millisecs
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
