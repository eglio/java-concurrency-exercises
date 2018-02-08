package eglio.sisop.comp;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egliocz on 12/06/17.
 */
public class Utente extends Thread {
    private Processore[] processori;
    private LinkedList<Thread> utenti;
    private Lock turno = new ReentrantLock();
    public void run(){
        while(true){
            try{
               turno.lock();
                utenti.add(Thread.currentThread());
                if (utenti.getFirst() == Thread.currentThread()){\

                }
            }
            finally{turno.unlock();}
    }

    public Utente(Processore[] processori, LinkedList<Thread> utenti) {
        this.processori=processori;
        this.utenti=utenti;
    }
}
