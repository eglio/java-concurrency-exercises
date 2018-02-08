package eglio.sisop.comp;

import java.util.concurrent.Semaphore;

/**
 * Created by egliocz on 12/06/17.
 */
public class ProcessoreSemaphore implements Processore {

    private Semaphore mutex= new Semaphore(4, true); //semaforo fair, processi risvegliati in ordine FIFO
    @Override
    public void assegna(int numCore) {
        try {
            mutex.acquire(numCore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rilascia(int numCore) {
        mutex.release(numCore);
    }
}
