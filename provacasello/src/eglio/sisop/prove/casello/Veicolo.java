package eglio.sisop.prove.casello;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by egliocz on 08/06/17.
 */
public class Veicolo extends Thread{
private int x; //chilometri percorsi
private Random r=new Random();
private Casello casello;
private Porta scelta;

    public Veicolo(Casello casello){
        this.casello=casello;
    }

    public void run() {
        x=50+r.nextInt(50);
        int tempo=x*40000; //millisecondi
        try{
            Thread.sleep(x); //percorro x chilometri
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int n=r.nextInt(casello.getN()); //scelgo porta
        scelta=casello.scegliPorta(n);
        try {
            scelta.accoda(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scelta.pagaEAbbandona(this, x);
        System.out.println("veicolo servito");
    }
}
