import java.util.concurrent.Semaphore;

/**
 * Created by egliocz on 14/06/17.
 */
public class CementificioSemaphore extends Cementificio {
    private Semaphore postiLiberi;
    private Semaphore sacchi;
    private Semaphore sacchiEsauriti;
    private int contatoreSacchi;

    public CementificioSemaphore(int n, int p) {
        super(n, p);
        this.contatoreSacchi=p;
        postiLiberi= new Semaphore(n,true); //semaforo fair, clienti entrano in ordine FIFO
        sacchi= new Semaphore(1);
        sacchiEsauriti= new Semaphore(1);
    }


    @Override
    public void entra() {
        try{
        postiLiberi.acquire();}
        catch(InterruptedException e){e.printStackTrace();}
    }

    @Override
    public void esci() {
        sacchi.release();
        postiLiberi.release();
    }

    @Override
    public void preleva() {
        try {
            sacchi.acquire();
            while (contatoreSacchi == 0) { //sacchi esauriti
                    sacchiEsauriti.acquire(); //il thread attende il completamento del rifornimento
                    sacchiEsauriti.release(); // rifornimento non iniziato
                } //sacchi disponibili

            contatoreSacchi--;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void iniziaRifornimento() {
        try{
            sacchi.acquire();
            sacchiEsauriti.acquire();
        } catch(InterruptedException e){e.printStackTrace();}

    }

    @Override
    public void terminaRifornimento() {
        contatoreSacchi=super.n;
        sacchiEsauriti.release();
        sacchi.release();
    }

}
