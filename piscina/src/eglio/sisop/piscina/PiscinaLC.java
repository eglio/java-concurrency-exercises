package eglio.sisop.piscina;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egliocz on 13/06/17.
 */
public class PiscinaLC implements Piscina {
    private int n;
    private int x;
    private Lock corsie[];
    private int postiLiberi[];

    public int entra(){
        //trova coda minore
        int minimo=0;
        for (int i=0; i<n; i++){
            if(postiLiberi[i]>postiLiberi[minimo]) minimo=i;
        }
        corsie[minimo].lock();
        postiLiberi[minimo]--;
        System.out.println("persona entrata in corsia LC" +minimo);
        return minimo;
    };

    public void esci(int corsia){
        postiLiberi[corsia]++;
        corsie[corsia].unlock();
        System.out.println("persona uncita da corsia LC " +corsia);
    };

    public PiscinaLC(int numCorsie, int capienza){
        n=numCorsie;
        x=capienza;
        corsie= new ReentrantLock[numCorsie];
        postiLiberi=new int[numCorsie];
        for(int i=0; i<numCorsie; i++){
            corsie[i]= new ReentrantLock(true); //fair lock, gestito con coda FIFO
            postiLiberi[i]=capienza;
        }
    }

}
