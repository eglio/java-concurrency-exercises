package eglio.sisop.comp;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egliocz on 12/06/17.
 */
public class ProcessoreLC implements Processore {
    private LinkedList<Thread> codaUtenti = new LinkedList<>();
    private int coreLiberi = 4;
    private Lock core = new ReentrantLock(true);
    private Condition nuovoTurno = core.newCondition();

    @Override
    public void assegna(int coreRichiesti) {
        try {
            core.lock();
            codaUtenti.add(Thread.currentThread());
            boolean mioTurno = (Thread.currentThread() == codaUtenti.getFirst());
            while (!mioTurno && (coreRichiesti > coreLiberi)) {
                nuovoTurno.await();
            }
            coreLiberi-=coreRichiesti;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    finally{
        core.unlock();
    }

}

    @Override
    public void rilascia(int numCore) {
        try{
            core.lock();
            codaUtenti.remove(Thread.currentThread());
            coreLiberi+=numCore;
            nuovoTurno.signalAll();
        } finally{
            core.unlock();
        }
    }
}
