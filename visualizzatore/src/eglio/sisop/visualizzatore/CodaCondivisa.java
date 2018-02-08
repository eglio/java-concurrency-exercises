package eglio.sisop.visualizzatore;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egliocz on 12/06/17.
 */
public class CodaCondivisa{
    private LinkedList<String> coda;
    private int MAX_ELEMENTI=100;
    private Lock mutex;
    private Condition spazioLiberato;
    private Condition codaNonVuota;

    public String getFirst() throws InterruptedException {
        try{
            mutex.lock();
        while (coda.isEmpty()) {
            codaNonVuota.await();}
        String first = coda.removeFirst();
        spazioLiberato.signalAll();
        return first;}
        finally{
            mutex.unlock();
        }}

    public void addCollection(Collection<String> elementi) throws InterruptedException{
        try{
        mutex.lock();
        int spazioRimasto=MAX_ELEMENTI-coda.size();
        while (spazioRimasto<elementi.size()) {
            spazioLiberato.await();
        }
        coda.addAll(coda);
        codaNonVuota.signal();
        } finally{mutex.unlock();}
    }

        public CodaCondivisa(){
            coda = new LinkedList<String>();
            mutex = new ReentrantLock();
            spazioLiberato =mutex.newCondition();
            codaNonVuota =mutex.newCondition();
        }
    }
