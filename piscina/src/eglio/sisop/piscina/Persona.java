package eglio.sisop.piscina;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 13/06/17.
 */
public class Persona extends Thread{
    private Random r = new Random();
    private int corsiaScelta;
    private Piscina piscina;
    private static int tempoPiscina=10;

    public void run(){
        //cambio
        int tempo= 2+r.nextInt(3);
        try{
            TimeUnit.SECONDS.sleep(tempo);
            corsiaScelta=piscina.entra();
            TimeUnit.SECONDS.sleep(tempoPiscina);
            piscina.esci(corsiaScelta);
            //doccia
            tempo = 5+ r.nextInt(6);
            TimeUnit.SECONDS.sleep(tempo);
        }
        catch (InterruptedException e){e.printStackTrace();}
    }

    public Persona(Piscina piscina){
        this.piscina=piscina;
    }
}
