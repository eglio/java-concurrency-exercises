package eglio.sisop.piscina;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.Semaphore;

/**
 * Created by egliocz on 13/06/17.
 */
public class PiscinaSemaphore implements Piscina {
    private int x; //capienza corsie
    private int n; //num corsie
    private Semaphore[] corsie;
    private int postiLiberi[];

    public int entra(){
        int minimo=0;
        for (int i =0;i<n; i++){
            if (postiLiberi[i]>postiLiberi[minimo]) {
                minimo=i;
            }
        }
        try {
            corsie[minimo].acquire();
            postiLiberi[minimo]--;
            System.out.println("persona entrata in corsia S" +minimo);
        } catch(InterruptedException e){e.printStackTrace();}
        return minimo; //corsia occupata
    }

    public void esci(int corsia){
        postiLiberi[corsia]++;
        corsie[corsia].release();
        System.out.println("persona uscita da corsia S" +corsia);
    }

    public PiscinaSemaphore(int numCorsie,int capienza){
        n=numCorsie;
        x=capienza;
        corsie = new Semaphore[numCorsie];
        postiLiberi = new int[numCorsie];
        for (int i=0; i<numCorsie;i++){
            corsie[i]= new Semaphore(capienza, true);
            postiLiberi[i]=capienza;
        }
    }

}
