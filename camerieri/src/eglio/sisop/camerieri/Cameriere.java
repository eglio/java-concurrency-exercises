package eglio.sisop.camerieri;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 12/06/17.
 */
public class Cameriere extends Thread {
    private SupportoPiattiLC scolapiatti;
    private int tempoRaccolta=3;
    private int piattiRaccolti=4;

    public Cameriere(SupportoPiattiLC sp){
        scolapiatti=sp;
    }

    public void run(){
        while(true){
            try{
                TimeUnit.SECONDS.sleep(tempoRaccolta);
            }
            catch (InterruptedException e){e.printStackTrace();}
            scolapiatti.put(piattiRaccolti);
            System.out.println("+ 4 piatti da lavare");
        }

}}
