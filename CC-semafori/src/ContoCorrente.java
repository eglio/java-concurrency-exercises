/**
 * Created by egliocz on 04/06/17.
 */
import java.util.concurrent.Semaphore;
class ContoCorrente { //versione thread-safe semafori
    protected int deposito;
    private Semaphore mutex;

    //costruttore
    public ContoCorrente(int D){
        deposito=D;
        mutex = new Semaphore(1);
    }

    public int getDeposito(){
        return this.deposito;
    }

    public void deposita(int importo) throws InterruptedException{
        mutex.acquire();
        this.deposito+=importo;
        mutex.release();
    }

    public void preleva(int importo) throws InterruptedException{
        mutex.acquire();
        this.deposito-=importo;
        mutex.release();
    }
}